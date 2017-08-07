package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tvos.dao.AlbumDao;
import org.tvos.dao.LikeDao;
import org.tvos.dao.PhotoDao;
import org.tvos.service.LikeService;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;

    @Autowired
    PhotoDao photoDao;

    @Autowired
    AlbumDao albumDao;


    /**
     *
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param username
     * @return true--点赞 false--取消点赞
     */
    @Transactional
    @Override
    public Boolean spotsLikeClick(String provinceName, String cityName, Long albumId, Long photoId, String username) {

        String photoName = getSpotsPhotoName(provinceName,cityName,albumId,photoId);
        String albumName = getSpotsAlbumName(provinceName,cityName,albumId);
        if(!likeDao.spotsLiked(provinceName,cityName,albumId,photoId,username)){//已点赞

            albumDao.spotsLikeSub(albumName);
            photoDao.likeSub(photoName,username);
            likeDao.spotsLikeCancel(provinceName,cityName,albumId,photoId,username);
            return false;
        }else {//未点赞
            albumDao.spotsLikeAdd(albumName);
            photoDao.likeAdd(photoName,username);
            likeDao.spotsLikeClick(provinceName,cityName,albumId,photoId,username);
            return true;
        }
    }

    @Transactional
    @Override
    public Boolean collegeLikeClick(String provinceName, Long albumId, Long photoId, String username) {

        String photoName = getCollegePhotoName(provinceName,albumId,photoId);
        String albumName = getCollegeAlbumName(provinceName,albumId);
        if(!likeDao.collegeLiked(provinceName,albumId,photoId,username)){
            albumDao.collegeLikeSub(albumName);
            photoDao.likeSub(photoName,username);
            likeDao.collegeLikeCancel(provinceName,albumId,photoId,username);
            return false;
        }else {
            albumDao.collegeLikeAdd(albumName);
            photoDao.likeAdd(photoName,username);
            likeDao.collegeLikeClick(provinceName,albumId,photoId,username);
            return true;
        }
    }

    /**
     * 将photoId转换成photoName
     * @param photoId
     * @return
     */
    private String getSpotsPhotoName(String provinceName,String cityName, Long albumId,Long photoId){
        return photoDao.getSpotsPhotoNameById(provinceName,cityName,albumId,photoId);

    }

    private String getCollegePhotoName(String provinceName, Long albumId,Long photoId){
        return photoDao.getCollegePhotoNameById(provinceName,albumId,photoId);

    }

    private String getSpotsAlbumName(String provinceName,String cityName, Long albumId){
        return albumDao.getSpotsAlbumNameById(provinceName,cityName,albumId);
    }

    private String getCollegeAlbumName(String provinceName, Long albumId){
        return albumDao.getCollegeAlbumNameById(provinceName,albumId);
    }

}
