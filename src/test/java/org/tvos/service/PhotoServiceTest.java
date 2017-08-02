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

    @Autowired
    PhotoService photoService;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getPhotoFromSpots() throws Exception {
        PhotoDto photoDto = photoService.getPhotoFromSpots("广东","潮州",Long.parseLong(String.valueOf(26)),Long.parseLong(String.valueOf(11)));
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
        PhotoDto photoDto = photoService.getPhotoFromCollege("GD",Long.parseLong(String.valueOf(1)),Long.parseLong(String.valueOf(1)));
        if(photoDto!=null) {
            System.out.println(photoDto);
        }else{
            photoDto = new PhotoDto();
        }
    }


    @Test
    public void getPhotoFromUserWork() throws Exception {
        List<PhotoDto> photoDtoList = photoService.getPhotoFromUserWork("cookie1","Mike");
        System.out.println(photoDtoList);
    }

    @Test
    public void getPhotoFromUserFavorite() throws Exception {
        List<PhotoDto> photoDtoList = photoService.getPhotoFromUserFavorite("cookie1","Mike");
        System.out.println(photoDtoList);
    }

}