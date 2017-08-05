package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tvos.dao.*;
import org.tvos.dto.PhotoDto;
import org.tvos.entity.Album;
import org.tvos.entity.Photo;
import org.tvos.service.PhotoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class PhotoServiceImpl implements PhotoService {

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


    /**
     * "photoId":Number,
     * "username":String,
     * "photoName":String,
     * "photoDescription":String,
     * "url":String,
     * "isLike":Boolean,
     * "likeNum":Number,
     * "time":Number
     * "isLast": Boolean
     * TODO 从点赞类获取isLike的属性
     */
    public PhotoDto getPhotoFromSpots(String provinceName, String cityName, Long albumId, Long photoId) {
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
            photoDto.setCreateTime(photo.getCreateTime());
            //photoDto.setLast(photo.getLast());
            //判断用户是否点赞此图片
            photoDto.setLike(like(photo.getPhotoName(), photo.getUsername()));//true已经点赞，like设为true
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
            photoDto.setCreateTime(photo.getCreateTime());
            photoDto.setLast(photo.getLast());
            //判断用户是否点赞此图片
            photoDto.setLike(like(photo.getPhotoName(), photo.getUsername()));//true已经点赞，like设为true
            return photoDto;
        } else {
            return photoDto;
        }

    }

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
            photoDto.setCreateTime(p.getCreateTime());
            photoDto.setLast(p.getLast());
            photoDtoList.add(photoDto);

        }
        return photoDtoList;
    }

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
            photoDto.setCreateTime(p.getCreateTime());
            photoDto.setLast(p.getLast());
            photoDtoList.add(photoDto);
        }
        return photoDtoList;
    }

    /**
     * 添加景点相片
     * TODO 获取图片url地址
     *
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
                                     String url) {
        Boolean isPhotoAdded = photoDao.addPhotoForSpots("", username, provinceName, cityName, albumName, photoName, photoDescription, url);
        Boolean isAlbumAdded = albumDao.addAlbumFromSpots(provinceName, cityName, albumName, url);
        Boolean isCityAdded = cityDao.addSpotsNum(cityName);
        Boolean isProvinceAdded = provinceDao.addSpotsNum(provinceName, cityName);
        return isPhotoAdded && isAlbumAdded && isCityAdded && isProvinceAdded;
    }

    /**
     * 添加高校相片
     * TODO 获取图片url地址
     *
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
                                       String url) {
        Boolean isPhotoAdded = photoDao.addPhotoForCollege("", username, provinceName, albumName, photoName, photoDescription, url);
        Boolean isProvinceAdded = provinceDao.addCollegeNum(provinceName);
        for (Album a : albumDao.getAlbumsFromCollege(provinceName)) {
            if (a.getAlbumName().equals(albumName)) {
                return albumDao.updateAlbumFromCollege(provinceName, albumName, url);
            }
        }
        Boolean isAlbumAdded = albumDao.addAlbumFromCollege(provinceName, albumName, url);
        return isPhotoAdded && isAlbumAdded && isProvinceAdded;
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
}
