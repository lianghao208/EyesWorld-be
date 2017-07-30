package org.tvos.dao;

import org.apache.ibatis.annotations.Param;
import org.tvos.entity.Photo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
public interface PhotoDao {

    /**
     * 景点照片
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    Photo getPhotoFromSpots(@Param(value="provinceName") String provinceName,
                            @Param(value="cityName") String cityName,
                            @Param(value="albumId") Long albumId,
                            @Param(value="photoId") Long photoId);

    /**
     * 大学照片
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    Photo getPhotoFromCollege(@Param(value="provinceName") String provinceName,
                              @Param(value="albumId") Long albumId,
                              @Param(value="photoId") Long photoId);

    /**
     * 用户照片
     * @param cookieId
     * @param userName
     * @return
     */
    List<Photo> getPhotoFromUserWork(@Param(value="cookieId") String cookieId,@Param(value="userName") String userName);

    /**
     * 用户收藏点赞的照片
     * @param cookieId
     * @param userName
     * @return
     */
    List<Photo> getPhotoFromUserFavorite(@Param(value="cookieId") String cookieId,@Param(value="userName") String userName);
}
