package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tvos.dao.LikeDao;
import org.tvos.service.LikeService;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;


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

        if(!likeDao.spotsLiked(provinceName,cityName,albumId,photoId,username)){
            likeDao.spotsLikeCancel(provinceName,cityName,albumId,photoId,username);
            return false;
        }else {
            likeDao.spotsLikeClick(provinceName,cityName,albumId,photoId,username);
            return true;
        }
    }

    @Override
    public Boolean collegeLikeClick(String provinceName, Long albumId, Long photoId, String username) {
        if(!likeDao.collegeLiked(provinceName,albumId,photoId,username)){
            likeDao.collegeLikeCancel(provinceName,albumId,photoId,username);
            return false;
        }else {
            likeDao.collegeLikeClick(provinceName,albumId,photoId,username);
            return true;
        }
    }
}
