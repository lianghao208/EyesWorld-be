package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.entity.Photo;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class PhotoDaoTest {
    @Test
    public void getProvinceNameByPhotoName() throws Exception {
        System.out.println(photoDao.getProvinceNameByPhotoName("abcd-1234567"));
    }

    @Test
    public void getCityNameByPhotoName() throws Exception {
        System.out.println(photoDao.getCityNameByPhotoName("abcd-1234567"));
    }

    @Test
    public void getSpotsPhotoNameById() throws Exception {
        System.out.println(photoDao.getSpotsPhotoNameById("广东",
                "佛山",Long.parseLong(String.valueOf(0)),Long.parseLong(String.valueOf(0))));
    }

    @Test
    public void getCollegePhotoNameById() throws Exception {
        System.out.println(photoDao.getCollegePhotoNameById("广东",
                Long.parseLong(String.valueOf(0)),Long.parseLong(String.valueOf(0))));
    }

    @Test
    public void getLikeAmount() throws Exception {
        System.out.println(photoDao.getLikeAmount("abcd-1234567","Mike"));
    }

    @Test
    public void likeSub() throws Exception {
        photoDao.likeSub("abcd-1234567","Mike");
    }

    @Test
    public void likeAdd() throws Exception {
        photoDao.likeAdd("abcd-1234567","Mike");

    }


    @Autowired
    PhotoDao photoDao;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getPhotoFromSpots() throws Exception {
        Photo photo = photoDao.getPhotoFromSpots("广东","佛山",Long.parseLong(String.valueOf(0)),Long.parseLong(String.valueOf(0)));
        System.out.println(photo);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getPhotoFromCollege() throws Exception {
        Photo photo = photoDao.getPhotoFromCollege("广东",Long.parseLong(String.valueOf(0)),Long.parseLong(String.valueOf(0)));
        System.out.println(photo);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getPhotoFromUserWork() throws Exception {
        List<Photo> photoList = photoDao.getPhotoFromUserWork("cookie1","Mike");
        System.out.println(photoList);
    }

    @Test
    public void getPhotoFromUserFavorite() throws Exception {
        List<Photo> photoList = photoDao.getPhotoFromUserFavorite("cookie1","Mike");
        System.out.println(photoList);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void addPhotoForSpots() throws Exception {
        Boolean isAdded = photoDao.addPhotoForSpots("cookie1",
                "Mike",
                "广东",
                "佛山",
                "家",
                "电脑图",
                "这是我的电脑",
                "www.baidu.com");

        System.out.println(isAdded);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void addPhotoForCollege() throws Exception {
        Boolean isAdded = photoDao.addPhotoForCollege("",
                "Mike",
                "广东",
                "华南理工大学",
                "我的大学",
                "这是我的电脑",
                "www.baidu.com");

        System.out.println(isAdded);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void deletePhotoForSpots() throws Exception {
        Boolean isDeleted = photoDao.deletePhotoForSpots("cookie1",
                "Mike",
                "GD",
                "guangzhou",
                "my album1",
                "flower",
                "");
        System.out.println(isDeleted);
    }

    /**
     * donw
     * @throws Exception
     */
    @Test
    public void deletePhotoForCollege() throws Exception {
        Boolean isDeleted = photoDao.deletePhotoForCollege("cookie1",
                "Mike",
                "GD",
                "my album1",
                "flower",
                "");
        System.out.println(isDeleted);
    }
}