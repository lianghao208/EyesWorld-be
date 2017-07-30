package org.tvos.dao;

import org.apache.ibatis.annotations.Param;
import org.tvos.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface AlbumDao {

    List<Album> getAlbumsFromSpots(@Param(value="provinceName")String provinceName, @Param(value="cityName") String cityName);

    List<Album> getAlbumsFromCollege(String provinceName);

    List<Album> getAlbumsFromRecommend();
}
