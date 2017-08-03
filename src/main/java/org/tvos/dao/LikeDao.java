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
    Boolean liked(@Param(value="provinceName") String provinceName,
                  @Param(value="cityName")String cityName,
                  @Param(value="albumId")Long albumId,
                  @Param(value="photoId")Long photoId,
                  @Param(value="username")String username);

    Boolean likeClick(@Param(value="provinceName") String provinceName,
                      @Param(value="cityName")String cityName,
                      @Param(value="albumId")Long albumId,
                      @Param(value="photoId")Long photoId,
                      @Param(value="username")String username);

    Boolean likeCancel(@Param(value="provinceName") String provinceName,
                       @Param(value="cityName")String cityName,
                       @Param(value="albumId")Long albumId,
                       @Param(value="photoId")Long photoId,
                       @Param(value="username")String username);

}
