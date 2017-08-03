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
    public void liked() throws Exception {

        /**
         * done
         */
        Boolean liked = likeDao.liked("广东","佛山",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),"Mike");
        System.out.println(liked);
    }


    @Test
    public void likeClick() throws Exception {

        Boolean likeClick =  likeDao.likeClick("广东","佛山",Long.valueOf(String.valueOf(1)),Long.valueOf(String.valueOf(1)),"Mike");
        System.out.println(likeClick);
    }

    @Test
    public void likeCancel() throws Exception {

        Boolean likeCancel =  likeDao.likeCancel("广东","佛山",Long.valueOf(String.valueOf(1)),Long.valueOf(String.valueOf(1)),"Mike");
        System.out.println(likeCancel);
    }

}