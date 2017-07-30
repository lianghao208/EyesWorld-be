package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.PhotoDao;
import org.tvos.dto.PhotoDto;
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

    /**
     * "photoId":Number,
     "username":String,
     "photoName":String,
     "photoDescription":String,
     "url":String,
     "isLike":Boolean,
     "likeNum":Number,
     "time":Number
     "isLast": Boolean
     TODO 从点赞类获取isLike的属性
     */
    public PhotoDto getPhotoFromSpots(String provinceName, String cityName, Long albumId, Long photoId) {
        Photo photo = photoDao.getPhotoFromSpots(provinceName,cityName,albumId,photoId);
        PhotoDto photoDto = new PhotoDto();
        photoDto.setPhotoId(photo.getPhotoId());
        photoDto.setUsername(photo.getUsername());
        photoDto.setPhotoName(photo.getPhotoName());
        photoDto.setPhotoDescription(photo.getPhotoDescription());
        photoDto.setUrl(photo.getUrl());
        //photoDto.setLike(photo.getLike());
        photoDto.setLikeAmount(photo.getLikeAmount());
        photoDto.setCreateTime(photo.getCreateTime());
        photoDto.setLast(photo.getLast());
        return photoDto;
    }

    public PhotoDto getPhotoFromCollege(String provinceName, Long albumId, Long photoId) {
        Photo photo = photoDao.getPhotoFromCollege(provinceName,albumId,photoId);
        PhotoDto photoDto = new PhotoDto();
        if(photo!=null){

            photoDto.setPhotoId(photo.getPhotoId());
            photoDto.setUsername(photo.getUsername());
            photoDto.setPhotoName(photo.getPhotoName());
            photoDto.setPhotoDescription(photo.getPhotoDescription());
            photoDto.setUrl(photo.getUrl());
            //photoDto.setLike(photo.getLike());
            photoDto.setLikeAmount(photo.getLikeAmount());
            photoDto.setCreateTime(photo.getCreateTime());
            photoDto.setLast(photo.getLast());
            return photoDto;
        }else{
            return photoDto;
        }

    }

    public List<PhotoDto> getPhotoFromUserWork(String cookieId, String userName) {
        List<PhotoDto> photoDtoList = new ArrayList<PhotoDto>();
        List<Photo> photoList = photoDao.getPhotoFromUserWork(cookieId,userName);
        for(Photo p:photoList){
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

    public List<PhotoDto> getPhotoFromUserFavorite(String cookieId, String userName) {
        List<PhotoDto> photoDtoList = new ArrayList<PhotoDto>();
        List<Photo> photoList = photoDao.getPhotoFromUserWork(cookieId,userName);
        for(Photo p:photoList){
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
}
