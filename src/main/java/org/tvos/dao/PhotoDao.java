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
     *
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    Photo getPhotoFromSpots(@Param(value = "provinceName") String provinceName,
                            @Param(value = "cityName") String cityName,
                            @Param(value = "albumId") Long albumId,
                            @Param(value = "photoId") Long photoId);

    /**
     * 大学照片
     *
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    Photo getPhotoFromCollege(@Param(value = "provinceName") String provinceName,
                              @Param(value = "albumId") Long albumId,
                              @Param(value = "photoId") Long photoId);

    /**
     * 用户照片
     *
     * @param cookieId
     * @param username
     * @return
     */
    List<Photo> getPhotoFromUserWork(@Param(value = "cookieId") String cookieId, @Param(value = "username") String username);

    /**
     * 用户收藏点赞的照片
     *
     * @param cookieId
     * @param username
     * @return
     */
    List<Photo> getPhotoFromUserFavorite(@Param(value = "cookieId") String cookieId, @Param(value = "username") String username);

    /**
     * 添加上传图片
     *
     * @param cookieId
     * @param username
     * @param provinceName
     * @param cityName
     * @param albumName
     * @return
     */
    Boolean addPhotoForSpots(@Param(value = "cookieId") String cookieId,
                             @Param(value = "username") String username,
                             @Param(value = "provinceName") String provinceName,
                             @Param(value = "cityName") String cityName,
                             @Param(value = "albumName") String albumName,
                             @Param(value = "photoName") String photoName,
                             @Param(value = "photoDescription") String photoDescription,
                             @Param(value = "url") String url);

    Boolean addPhotoForCollege(@Param(value = "cookieId") String cookieId,
                               @Param(value = "username") String username,
                               @Param(value = "provinceName") String provinceName,
                               @Param(value = "albumName") String albumName,
                               @Param(value = "photoName") String photoName,
                               @Param(value = "photoDescription") String photoDescription,
                               @Param(value = "url") String url);

    /**
     * 用图片url来删除资源
     * @param cookieId
     * @param username
     * @param provinceName
     * @param cityName
     * @param albumName
     * @param photoName
     * @param url
     * @return
     */
    Boolean deletePhotoForSpots(@Param(value = "cookieId") String cookieId,
                                @Param(value = "username") String username,
                                @Param(value = "provinceName") String provinceName,
                                @Param(value = "cityName") String cityName,
                                @Param(value = "albumName") String albumName,
                                @Param(value = "photoName") String photoName,
                                @Param(value = "url") String url);

    /**
     * 删除用户上传的图片
     * @param photoName
     * @param username
     * @return
     */
    Boolean deletePhoto(@Param(value = "photoName") String photoName, @Param(value = "username") String username);

    /**
     * 用图片url来删除资源
     * @param cookieId
     * @param username
     * @param provinceName
     * @param albumName
     * @param photoName
     * @param url
     * @return
     */
    Boolean deletePhotoForCollege(@Param(value = "cookieId") String cookieId,
                                  @Param(value = "username") String username,
                                  @Param(value = "provinceName") String provinceName,
                                  @Param(value = "albumName") String albumName,
                                  @Param(value = "photoName") String photoName,
                                  @Param(value = "url") String url);


    Boolean likeAdd(@Param(value = "photoName") String photoName,
                         @Param(value = "username") String username);

    Boolean likeSub(@Param(value = "photoName") String photoName,
                    @Param(value = "username") String username);

    int getLikeAmount(@Param(value = "photoName") String photoName,
                      @Param(value = "username") String username);

    String getSpotsPhotoNameById(@Param(value = "provinceName") String provinceName,
                            @Param(value = "cityName") String cityName,
                            @Param(value = "albumId") Long albumId,
                            @Param(value = "photoId") Long photoId);

    String getCollegePhotoNameById(@Param(value = "provinceName") String provinceName,
                                   @Param(value = "albumId") Long albumId,
                                   @Param(value = "photoId") Long photoId);


    //暂时不启用
    Boolean lastSpotsPhoto(@Param(value = "provinceName") String provinceName,
                           @Param(value = "cityName") String cityName,
                           @Param(value = "albumId") Long albumId,
                           @Param(value = "photoId") Long photoId,
                           @Param(value = "username") String username);

    Boolean lastCollegePhoto(@Param(value = "provinceName") String provinceName,
                             @Param(value = "albumId") Long albumId,
                             @Param(value = "photoId") Long photoId,
                             @Param(value = "username") String username);


}
