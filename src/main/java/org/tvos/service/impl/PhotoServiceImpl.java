package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tvos.dao.*;
import org.tvos.dao.cache.RedisDao;
import org.tvos.dto.PhotoDto;
import org.tvos.entity.Album;
import org.tvos.entity.Photo;
import org.tvos.exception.DeleteException;
import org.tvos.exception.UploadException;
import org.tvos.service.PhotoService;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    PhotoDao photoDao;
    @Autowired
    AlbumDao albumDao;
    @Autowired
    CityDao cityDao;
    @Autowired
    ProvinceDao provinceDao;

    @Autowired
    LikeDao LikeDao;

    @Autowired
    RedisDao redisDao;

    /**
     * 得到景点图片
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    public PhotoDto getPhotoFromSpots(String provinceName, String cityName, Long albumId, Long photoId)
             {
        //Redis缓存优化
        //1.访问redis
/*        Photo photo = redisDao.getPhotoFromSpots(provinceName,cityName,albumId,photoId);
        if(photo == null){
            photo = photoDao.getPhotoFromSpots(provinceName,cityName,albumId,photoId);
            if(photo == null){
                //图片不存在，返回空对象
                return new PhotoDto();
            }else {
                redisDao.putPhotoFromSpots(photo);
            }
        }*/

        Photo photo = photoDao.getPhotoFromSpots(provinceName, cityName, albumId, photoId);
        System.out.println("+1:"+photoDao.getPhotoFromSpots(provinceName,cityName,albumId,(photoId+1)));
        System.out.println("photo:"+photo);
        PhotoDto photoDto = new PhotoDto();
        if (photo != null) {
            photoDto.setPhotoId(photo.getPhotoId());
            photoDto.setUsername(photo.getUsername());
            photoDto.setPhotoName(photo.getPhotoName());
            photoDto.setPhotoDescription(photo.getPhotoDescription());
            photoDto.setUrl(photo.getUrl());
            //photoDto.setLike(photo.getLike());
            photoDto.setLikeAmount(photo.getLikeAmount());
            photoDto.setCreateTime(photo.getModificationTime());
            //photoDto.setLast(photo.getLast());
            //判断用户是否点赞此图片
            photoDto.setLike(like(photo.getPhotoName(), photo.getUsername()));//true已经点赞，like设为true
            //景点访问量+1
            albumDao.spotsVisitAdd(albumDao.getSpotsAlbumNameById(provinceName,cityName,albumId));
            //判断该相片是否为最后一张
            if(photoDao.getPhotoFromSpots(provinceName,cityName,albumId,(photoId+1))==null){
                photoDto.setLast(true);
            }else {
                photoDto.setLast(false);
            }
            return photoDto;
        } else {
            return photoDto;
        }
    }

    /**
     * 得到高校图片
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    public PhotoDto getPhotoFromCollege(String provinceName, Long albumId, Long photoId) {
        Photo photo = photoDao.getPhotoFromCollege(provinceName, albumId, photoId);
        PhotoDto photoDto = new PhotoDto();
        if (photo != null) {

            photoDto.setPhotoId(photo.getPhotoId());
            photoDto.setUsername(photo.getUsername());
            photoDto.setPhotoName(photo.getPhotoName());
            photoDto.setPhotoDescription(photo.getPhotoDescription());
            photoDto.setUrl(photo.getUrl());
            //photoDto.setLike(photo.getLike());
            photoDto.setLikeAmount(photo.getLikeAmount());
            photoDto.setCreateTime(photo.getModificationTime());
            photoDto.setLast(photo.getLast());
            //判断用户是否点赞此图片
            photoDto.setLike(like(photo.getPhotoName(), photo.getUsername()));//true已经点赞，like设为true
            //高校相册访问量+1
            albumDao.spotsVisitAdd(albumDao.getCollegeAlbumNameById(provinceName,albumId));
            //判断该相片是否为最后一张
            if(photoDao.getPhotoFromCollege(provinceName,albumId,(photoId+1))==null){
                photoDto.setLast(true);
            }else {
                photoDto.setLast(false);
            }
            return photoDto;
        } else {
            return photoDto;
        }

    }

    /**
     * 得到用户图片
     * @param cookieId
     * @param userName
     * @return
     */
    public List<PhotoDto> getPhotoFromUserWork(String cookieId, String userName) {
        List<PhotoDto> photoDtoList = new ArrayList<PhotoDto>();
        List<Photo> photoList = photoDao.getPhotoFromUserWork(cookieId, userName);
        for (Photo p : photoList) {
            PhotoDto photoDto = new PhotoDto();
            photoDto.setPhotoId(p.getPhotoId());
            photoDto.setUsername(p.getUsername());
            photoDto.setPhotoName(p.getPhotoName());
            photoDto.setPhotoDescription(p.getPhotoDescription());
            photoDto.setUrl(p.getUrl());
            //photoDto.setLike(photo.getLike());
            photoDto.setLikeAmount(p.getLikeAmount());
            photoDto.setCreateTime(p.getModificationTime());
            photoDto.setLast(p.getLast());
            //判断用户是否点赞此图片
            photoDto.setLike(like(p.getPhotoName(), p.getUsername()));//true已经点赞，like设为true
            photoDtoList.add(photoDto);

        }
        return photoDtoList;
    }

    /**
     * 得到用户点赞的图片
     * @param cookieId
     * @param username
     * @return
     */
    public List<PhotoDto> getPhotoFromUserFavorite(String cookieId, String username) {
        List<PhotoDto> photoDtoList = new ArrayList<PhotoDto>();
        List<Photo> photoList = photoDao.getPhotoFromUserFavorite(cookieId, username);
        for (Photo p : photoList) {
            PhotoDto photoDto = new PhotoDto();
            photoDto.setPhotoId(p.getPhotoId());
            photoDto.setUsername(p.getUsername());
            photoDto.setPhotoName(p.getPhotoName());
            photoDto.setPhotoDescription(p.getPhotoDescription());
            photoDto.setUrl(p.getUrl());
            //photoDto.setLike(photo.getLike());
            photoDto.setLikeAmount(p.getLikeAmount());
            photoDto.setCreateTime(p.getModificationTime());
            photoDto.setLast(p.getLast());
            //判断用户是否点赞此图片
            photoDto.setLike(like(p.getPhotoName(), p.getUsername()));//true已经点赞，like设为true
            photoDtoList.add(photoDto);
        }
        return photoDtoList;
    }

    /**
     * 添加景点相片
     * @param username
     * @param albumName
     * @param photoName
     * @param photoDescription
     * @param provinceName
     * @param cityName
     * @return
     */
    @Transactional
    public Boolean addPhotoFromSpots(String username,
                                     String albumName,
                                     String photoName,
                                     String photoDescription,
                                     String provinceName,
                                     String cityName,
                                     String url) throws UploadException{
        Boolean isAlbumAdded = albumDao.addAlbumFromSpots(provinceName, cityName, albumName, url);
        Boolean isPhotoAdded = photoDao.addPhotoForSpots("", username, provinceName, cityName, albumName, photoName, photoDescription, url);
        Boolean isCityAdded = cityDao.addSpotsNum(cityName);
        Boolean isProvinceAdded = provinceDao.addSpotsNum(provinceName, cityName);
        if(isPhotoAdded && isAlbumAdded && isCityAdded && isProvinceAdded){
            return isPhotoAdded && isAlbumAdded && isCityAdded && isProvinceAdded;
        }else {
            throw  new UploadException("文件上传失败");
        }


    }

    /**
     * 添加高校相片
     * @param username
     * @param albumName
     * @param photoName
     * @param photoDescription
     * @param provinceName
     * @return
     */
    @Transactional
    public Boolean addPhotoFromCollege(String username,
                                       String albumName,
                                       String photoName,
                                       String photoDescription,
                                       String provinceName,
                                       String url) throws UploadException{

/*        for (Album a : albumDao.getAlbumsFromCollege(provinceName)) {
            if (a.getAlbumName().equals(albumName)) {
                return albumDao.updateAlbumFromCollege(provinceName, albumName, url);
            }
        }*/


        Boolean isAlbumAdded = albumDao.addAlbumFromCollege(provinceName, albumName, url);
        //System.out.println("cutcutcut");
        Boolean isPhotoAdded = photoDao.addPhotoForCollege("", username, provinceName, albumName, photoName, photoDescription, url);
        Boolean isProvinceAdded = provinceDao.addCollegeNum(provinceName);
        if(isPhotoAdded && isAlbumAdded && isProvinceAdded){
            return isPhotoAdded && isAlbumAdded && isProvinceAdded;
        }else {
            throw  new UploadException("文件上传失败");
        }
       // return isPhotoAdded && isAlbumAdded && isProvinceAdded;
    }


    /**
     * 通过相片名和用户名得到用户和图片之间点赞的关系
     *
     * @param photoName
     * @param username
     * @return treu---没有点赞，数据库中没有点赞信息  false---已经点赞，数据库找到点赞信息
     */
    Boolean like(String photoName, String username) {
        return LikeDao.liked(photoName, username);
    }

    /**
     * 删除用户图片
     * @param photoName
     * @param username
     * @return
     */
    @Transactional
    public Boolean deletePhoto(String photoName,String username)
            throws DeleteException{

        //1.更新数据库相册表的数据
        Boolean isUpdateSpotsAlbumCover = albumDao.updateSpotsAlbumCover(photoName);
        Boolean isUpdateCollegeAlbumCover = albumDao.updateCollegeAlbumCover(photoName);

        //2.景点、高校图片数减一
        if(isUpdateSpotsAlbumCover){
            Boolean isSubSpotsProvince = provinceDao.subSpotsNum(getProvinceNameByPhotoName(photoName),getCityNameByPhotoName(photoName));
            Boolean isSubSpotsCity = cityDao.subSpotsNum(getCityNameByPhotoName(photoName));
            System.out.println("isSubSpotsProvince:"+isSubSpotsProvince);
            System.out.println("isSubSpotsCity:"+isSubSpotsCity);
        }else if (isUpdateCollegeAlbumCover){
            provinceDao.subCollegeNum(getProvinceNameByPhotoName(photoName));
        }

        //3.删除数据库图片数据
        Boolean isPhotoDeleted = photoDao.deletePhoto(photoName,username);
        //4.删除磁盘中图片数据
        Boolean isPhotoDeletedFromDisk = photoDelete(photoName);
        if((isUpdateSpotsAlbumCover || isUpdateCollegeAlbumCover) && isPhotoDeleted){
            return (isUpdateSpotsAlbumCover || isUpdateCollegeAlbumCover) && isPhotoDeleted;
        }else {
            throw  new DeleteException("图片数据库删除失败");
        }
    }

    /**
     * 推荐图片
     * @return
     */
    public List<PhotoDto> getPhotosFromRecommend() {
        return null;
    }

    private Boolean photoDelete(String photoName){
        File deleteSpotsFile = new File("C:\\upload\\spotsPhoto\\"+photoName);
        File deleteCollegeFile = new File("C:\\upload\\collegePhoto\\"+photoName);
        if(deleteSpotsFile.isFile() && deleteSpotsFile.exists()){
            deleteSpotsFile.delete();
            return true;
        }else if(deleteCollegeFile.isFile() && deleteCollegeFile.exists()){
            deleteCollegeFile.delete();
            return true;
        }else
            return false;

    }

    /**
     * 通过图片名得到省份名
     * @param photoName
     * @return
     */
    private String getProvinceNameByPhotoName(String photoName){
        //TODO
        return photoDao.getProvinceNameByPhotoName(photoName);
    }

    /**
     * 通过图片名得到城市名
     * @param photoName
     * @return
     */
    private String getCityNameByPhotoName(String photoName){
        //TODO
        return photoDao.getCityNameByPhotoName(photoName);
    }
}
