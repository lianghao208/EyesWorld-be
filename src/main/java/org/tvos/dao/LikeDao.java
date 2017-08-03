package org.tvos.dao;

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
    Boolean spotsLiked(@Param(value="provinceName") String provinceName,
                  @Param(value="cityName")String cityName,
                  @Param(value="albumId")Long albumId,
                  @Param(value="photoId")Long photoId,
                  @Param(value="username")String username);

    Boolean spotsLikeClick(@Param(value="provinceName") String provinceName,
                      @Param(value="cityName")String cityName,
                      @Param(value="albumId")Long albumId,
                      @Param(value="photoId")Long photoId,
                      @Param(value="username")String username);

    Boolean spotsLikeCancel(@Param(value="provinceName") String provinceName,
                       @Param(value="cityName")String cityName,
                       @Param(value="albumId")Long albumId,
                       @Param(value="photoId")Long photoId,
                       @Param(value="username")String username);

    Boolean collegeLiked(@Param(value="provinceName") String provinceName,
                       @Param(value="albumId")Long albumId,
                       @Param(value="photoId")Long photoId,
                       @Param(value="username")String username);

    Boolean collegeLikeClick(@Param(value="provinceName") String provinceName,
                           @Param(value="albumId")Long albumId,
                           @Param(value="photoId")Long photoId,
                           @Param(value="username")String username);

    Boolean collegeLikeCancel(@Param(value="provinceName") String provinceName,
                            @Param(value="albumId")Long albumId,
                            @Param(value="photoId")Long photoId,
                            @Param(value="username")String username);

}
