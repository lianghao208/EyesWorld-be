package org.tvos.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface LikeDao {

    /**
     * 判断用户是否点赞
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param username
     * @return 没有点赞true 已经点赞false
     */
    Boolean spotsLiked(@Param(value = "provinceName") String provinceName,
                       @Param(value = "cityName") String cityName,
                       @Param(value = "albumId") Long albumId,
                       @Param(value = "photoId") Long photoId,
                       @Param(value = "username") String username);

    Boolean spotsLikeClick(@Param(value = "provinceName") String provinceName,
                           @Param(value = "cityName") String cityName,
                           @Param(value = "albumId") Long albumId,
                           @Param(value = "photoId") Long photoId,
                           @Param(value = "username") String username);

    Boolean spotsLikeCancel(@Param(value = "provinceName") String provinceName,
                            @Param(value = "cityName") String cityName,
                            @Param(value = "albumId") Long albumId,
                            @Param(value = "photoId") Long photoId,
                            @Param(value = "username") String username);

    Boolean collegeLiked(@Param(value = "provinceName") String provinceName,
                         @Param(value = "albumId") Long albumId,
                         @Param(value = "photoId") Long photoId,
                         @Param(value = "username") String username);

    Boolean collegeLikeClick(@Param(value = "provinceName") String provinceName,
                             @Param(value = "albumId") Long albumId,
                             @Param(value = "photoId") Long photoId,
                             @Param(value = "username") String username);

    Boolean collegeLikeCancel(@Param(value = "provinceName") String provinceName,
                              @Param(value = "albumId") Long albumId,
                              @Param(value = "photoId") Long photoId,
                              @Param(value = "username") String username);

    //TODO 点赞数增加功能、获取点赞数、是否为最后一张照片
    Boolean spotsLikeAdd(@Param(value = "provinceName") String provinceName,
                         @Param(value = "cityName") String cityName,
                         @Param(value = "albumId") Long albumId,
                         @Param(value = "photoId") Long photoId,
                         @Param(value = "username") String username);

    Boolean collegeLikeAdd(@Param(value = "provinceName") String provinceName,
                           @Param(value = "albumId") Long albumId,
                           @Param(value = "photoId") Long photoId,
                           @Param(value = "username") String username);

    int getLikeAmountForSpots(@Param(value = "provinceName") String provinceName,
                              @Param(value = "cityName") String cityName,
                              @Param(value = "albumId") Long albumId,
                              @Param(value = "photoId") Long photoId,
                              @Param(value = "username") String username);

    int getLikeAmountForCollege(@Param(value = "provinceName") String provinceName,
                                @Param(value = "albumId") Long albumId,
                                @Param(value = "photoId") Long photoId,
                                @Param(value = "username") String username);

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
