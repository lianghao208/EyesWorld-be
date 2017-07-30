package org.tvos.service;

import org.tvos.dto.AlbumDto;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface AlbumService {

    /**
     * 景点相册
     * @param provinceName
     * @param cityName
     * @return
     */
    List<AlbumDto> getAlbumsFromSpots(String provinceName,String cityName);

    /**
     * 高校相册
     * @param provinceName
     * @return
     */
    List<AlbumDto> getAlbumsFromCollege(String provinceName);

    /**
     * 推荐相册
     * @return
     */
    List<AlbumDto> getAlbumsFromRecommend();
}
