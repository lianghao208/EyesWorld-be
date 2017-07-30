package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dto.AlbumDto;
import org.tvos.entity.Album;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class AlbumDaoTest {

    @Autowired
    AlbumDao albumDao;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getAlbumsFromSpots() throws Exception {
        List<Album> albumList = albumDao.getAlbumsFromSpots("GD","guangzhou");
        for(Album album:albumList){
            System.out.println(album);
        }
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getAlbumsFromCollege() throws Exception {
        List<Album> albumList = albumDao.getAlbumsFromCollege("GX");
        for(Album album:albumList){
            System.out.println(album);
        }
    }

}