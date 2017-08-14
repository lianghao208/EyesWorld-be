package org.tvos.service;

import org.springframework.stereotype.Service;
import org.tvos.dto.PhotoDto;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface PhotoService {

    /**
     * 景点相片
     * @param provinceName
     * @param cityName
     * @param AlbumId
     * @param PhotoId
     * @return
     */
    PhotoDto getPhotoFromSpots(String provinceName,String cityName,Long AlbumId,Long PhotoId);

    /**
     * 高校相片
     * @param provinceName
     * @param AlbumId
     * @param PhotoId
     * @return
     */
    PhotoDto getPhotoFromCollege(String provinceName,Long AlbumId,Long PhotoId);

    /**
     * 用户上传图
     * @param cookieId
     * @param userName
     * @return
     */
    List<PhotoDto> getPhotoFromUserWork(String cookieId, String userName);

    /**
     * 用户收藏图
     * @param cookieId
     * @param userName
     * @return
     */
    List<PhotoDto> getPhotoFromUserFavorite(String cookieId, String userName);

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
    Boolean addPhotoFromSpots(String username,String albumName,String photoName,String photoDescription,String provinceName,String cityName,String url);

    /**
     * 添加高校相片
     * @param username
     * @param albumName
     * @param photoName
     * @param photoDescription
     * @param provinceName
     * @return
     */
    Boolean addPhotoFromCollege(String username,String albumName,String photoName,String photoDescription,String provinceName,String url);

    /**
     * 删除用户照片
     * @param photoName
     * @param username
     * @return
     */
    Boolean deletePhoto(String photoName,String username);

    /**
     * 推荐图片
     * @return
     */
    List<PhotoDto> getPhotosFromRecommend();
}
