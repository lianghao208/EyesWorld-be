package org.tvos.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface LikeService {

    /**
     * 用户点击景点点赞按钮
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param username
     * @return
     */
    Boolean spotsLikeClick(String provinceName,String cityName,Long albumId,Long photoId,String username);

    /**
     * 用户点击高校点赞按钮
     * @param provinceName
     * @param albumId
     * @param photoId
     * @param username
     * @return
     */
    Boolean collegeLikeClick(String provinceName,Long albumId,Long photoId,String username);
}
