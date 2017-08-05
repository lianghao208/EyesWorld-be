package org.tvos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.tvos.dao.PhotoDao;

/**
 * Created by Administrator on 2017/8/5.
 */
public class IdToNameUtil {

    @Autowired
    PhotoDao photoDao;

    public String getSpotsPhotoName(String provinceName,String cityName, Long albumId,Long photoId){
        return photoDao.getSpotsPhotoNameById(provinceName,cityName,albumId,photoId);

    }

    public String getCollegePhotoName(String provinceName, Long albumId,Long photoId){
        return photoDao.getCollegePhotoNameById(provinceName,albumId,photoId);

    }
}
