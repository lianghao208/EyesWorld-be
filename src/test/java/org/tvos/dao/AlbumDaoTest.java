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
    @Test
    public void spotsVisitAdd() throws Exception {
        System.out.println(albumDao.spotsVisitAdd("我的相册3"));
    }

    @Test
    public void collegeVisitAdd() throws Exception {
        System.out.println(albumDao.collegeVisitAdd("我的高校"));
    }

    @Test
    public void getSpotsVisitAmount() throws Exception {
        System.out.println(albumDao.getSpotsVisitAmount("我的相册3"));
    }

    @Test
    public void getCollegeVisitAmount() throws Exception {
        System.out.println(albumDao.getCollegeVisitAmount("我的高校"));
    }

    @Test
    public void getSpotsAlbumNameById() throws Exception {
        System.out.println(albumDao.getSpotsAlbumNameById("广东","潮州",Long.valueOf(String.valueOf(0))));
    }

    @Test
    public void getCollegeAlbumNameById() throws Exception {
        System.out.println(albumDao.getCollegeAlbumNameById("广东",Long.valueOf(String.valueOf(0))));
    }

    @Test
    public void spotsLikeAdd() throws Exception {
        albumDao.spotsLikeAdd("我的相册3");
    }

    @Test
    public void collegeLikeAdd() throws Exception {
        albumDao.collegeLikeAdd("我的相册4");
    }

    @Test
    public void spotsLikeSub() throws Exception {
        albumDao.spotsLikeSub("我的相册3");
    }

    @Test
    public void collegeLikeSub() throws Exception {
        albumDao.collegeLikeSub("我的相册4");
    }

    @Test
    public void getSpotsLikeAmount() throws Exception {
        System.out.println(albumDao.getSpotsLikeAmount("我的相册3"));
    }

    @Test
    public void getCollegeLikeAmount() throws Exception {
        System.out.println(albumDao.getCollegeLikeAmount("我的相册4"));
    }


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

    @Test
    public void getAlbumsFromRecommend() throws Exception {
    }

    @Test
    public void addAlbumFromSpots() throws Exception {
            Boolean isAdded = albumDao.addAlbumFromSpots("GD","guangzhou","我的相册","www.baidu.com");
            System.out.println(isAdded);
    }

    @Test
    public void addAlbumFromCollege() throws Exception {
        Boolean isAdded = albumDao.addAlbumFromCollege("GD","我的大学相册","www.baidu.com");
        System.out.println(isAdded);
    }

    @Test
    public void updateAlbumFromSpots() throws Exception {

    }

    @Test
    public void updateAlbumFromCollege() throws Exception {
    }

    @Test
    public void deleteAlbumFromSpots() throws Exception {

        Boolean isAdded = albumDao.deleteAlbumFromSpots("GD","guangzhou","我的景点相册","www.baidu.com");
        System.out.println(isAdded);
    }

    @Test
    public void deleteAlbumFromCollege() throws Exception {
        Boolean isAdded = albumDao.deleteAlbumFromCollege("GD","我的大学相册","www.baidu.com");
        System.out.println(isAdded);
    }

}