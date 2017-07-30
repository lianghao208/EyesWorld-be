package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.AlbumDao;
import org.tvos.dto.AlbumDto;
import org.tvos.entity.Album;
import org.tvos.service.AlbumService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDao albumDao;
    public List<AlbumDto> getAlbumsFromSpots(String provinceName, String cityName) {
        List<AlbumDto> albumDtoList = new ArrayList<AlbumDto>();
        List<Album> albumList = albumDao.getAlbumsFromSpots(provinceName,cityName);
        //将 provinceList 转换成 provinceDtoList
        for(Album a: albumList){
            AlbumDto albumDto = new AlbumDto();
            albumDto.setAlbumId(a.getAlbumId());
            albumDto.setAlbumName(a.getAlbumName());
            albumDto.setLikeAmount(a.getLikeAmount());
            albumDto.setVisitAmount(a.getVisitAmount());
            albumDto.setUrl(a.getUrl());
            albumDtoList.add(albumDto);

        }
        return albumDtoList;
    }

    public List<AlbumDto> getAlbumsFromCollege(String provinceName) {
        List<AlbumDto> albumDtoList = new ArrayList<AlbumDto>();
        List<Album> albumList = albumDao.getAlbumsFromCollege(provinceName);
        //将 provinceList 转换成 provinceDtoList
        for(Album a: albumList){
            AlbumDto albumDto = new AlbumDto();
            albumDto.setAlbumId(a.getAlbumId());
            albumDto.setAlbumName(a.getAlbumName());
            albumDto.setLikeAmount(a.getLikeAmount());
            albumDto.setVisitAmount(a.getVisitAmount());
            albumDto.setUrl(a.getUrl());
            albumDtoList.add(albumDto);

        }
        return albumDtoList;
    }

    public List<AlbumDto> getAlbumsFromRecommend() {
        return null;
    }
}
