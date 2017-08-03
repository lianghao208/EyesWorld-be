package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.tvos.dao.LikeDao;
import org.tvos.service.LikeService;

/**
 * Created by Administrator on 2017/8/3.
 */
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;


    @Transactional
    @Override
    public Boolean likeClick(String provinceName, String cityName, Long albumId, Long photoId, String username) {

        if(!likeDao.liked(provinceName,cityName,albumId,photoId,username)){
            return likeDao.likeCancel(provinceName,cityName,albumId,photoId,username);
        }else {
            return likeDao.likeClick(provinceName,cityName,albumId,photoId,username);
        }
    }
}
