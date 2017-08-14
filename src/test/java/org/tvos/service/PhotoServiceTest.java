package org.tvos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dto.PhotoDto;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class PhotoServiceTest {

    @Test
    public void addPhotoFromSpots() throws Exception {

        Boolean isAdded = photoService.addPhotoFromSpots("Mike",
                "相册",
                "相片",
                "678",
                "广东",
                "珠海",
                        "www.123.com");
        System.out.println(isAdded);
    }

    @Test
    public void addPhotoFromCollege() throws Exception {
        Boolean isAdded = photoService.addPhotoFromCollege("Mike",
                "华南理工大学",
                "我的大学",
                "6789000",
                "广东",
                "www.123.com");
        System.out.println(isAdded);
    }

    @Autowired
    PhotoService photoService;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getPhotoFromSpots() throws Exception {
        PhotoDto photoDto = photoService.getPhotoFromSpots("广东","潮州",Long.parseLong(String.valueOf(0)),Long.parseLong(String.valueOf(0)));
        if(photoDto!=null) {
            System.out.println(photoDto);
        }else{
            photoDto = new PhotoDto();
        }
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getPhotoFromCollege() throws Exception {
        PhotoDto photoDto = photoService.getPhotoFromCollege("广东",Long.parseLong(String.valueOf(0)),Long.parseLong(String.valueOf(0)));
        if(photoDto!=null) {
            System.out.println(photoDto);
        }else{
            photoDto = new PhotoDto();
        }
    }


    @Test
    public void getPhotoFromUserWork() throws Exception {
        List<PhotoDto> photoDtoList = photoService.getPhotoFromUserWork("","Mike");
        System.out.println(photoDtoList);
    }

    @Test
    public void getPhotoFromUserFavorite() throws Exception {
        List<PhotoDto> photoDtoList = photoService.getPhotoFromUserFavorite("","Mike");
        System.out.println(photoDtoList);
    }

}