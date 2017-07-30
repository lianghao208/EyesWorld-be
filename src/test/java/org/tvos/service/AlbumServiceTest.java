package org.tvos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dto.AlbumDto;
import org.tvos.entity.Album;
import org.tvos.entity.City;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class AlbumServiceTest {
    @Autowired
    AlbumService albumService;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getAlbumsFromSpots() throws Exception {
        List<AlbumDto> albumDtoList = albumService.getAlbumsFromSpots("GD","guangzhou");
        for(AlbumDto cityDto:albumDtoList){
            System.out.println(cityDto);
        }
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getAlbumsFromCollege() throws Exception {
        List<AlbumDto> albumDtoList = albumService.getAlbumsFromCollege("GX");
        for(AlbumDto cityDto:albumDtoList){
            System.out.println(cityDto);
        }
    }

}