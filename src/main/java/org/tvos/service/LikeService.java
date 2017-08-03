package org.tvos.service;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface LikeService {

    /**
     * 用户点击点赞按钮
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param username
     * @return
     */
    Boolean likeClick(String provinceName,String cityName,Long albumId,Long photoId,String username);
}
