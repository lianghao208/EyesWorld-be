package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class LikeDaoTest {

    @Autowired
    LikeDao likeDao;

    @Test
    public void spotsLiked() throws Exception {

        /**
         * done  true--可以点赞   false----不可用点赞
         */
        Boolean liked = likeDao.spotsLiked("广东","佛山",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(liked);
    }

    @Test
    public void spotsLikeClick() throws Exception {

        Boolean likeClick =  likeDao.spotsLikeClick("广东","佛山",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(likeClick);
    }

    @Test
    public void spotsLikeCancel() throws Exception {

        Boolean likeCancel =  likeDao.spotsLikeCancel("广东","佛山",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(likeCancel);
    }

    @Test
    public void collegeLiked() throws Exception {
        Boolean liked = likeDao.collegeLiked("广东",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(liked);
    }

    @Test
    public void collegeLikeClick() throws Exception {

        Boolean likeCancel =  likeDao.collegeLikeClick("广东",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(likeCancel);
    }

    @Test
    public void collegeLikeCancel() throws Exception {

        Boolean likeCancel =  likeDao.collegeLikeCancel("广东",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(likeCancel);
    }




}