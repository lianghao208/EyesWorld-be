package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.entity.CommentList;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class CommentListDaoTest {

    @Autowired
    CommentListDao commentListDao;
    @Test
    public void getPhotoCommentListFromSpots() throws Exception {
        List<CommentList> commentListList = commentListDao.getPhotoCommentListFromSpots("广东","潮州",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(commentListList);
    }

    @Test
    public void getPhotoCommentListFromCollege() throws Exception {
        List<CommentList> commentListList = commentListDao.getPhotoCommentListFromCollege("广东",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(commentListList);
    }

    @Test
    public void addCommentForSpots() throws Exception {
        Boolean isAdded = commentListDao.addCommentForSpots("广东","佛山","Mike","333",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(isAdded);
    }

    @Test
    public void addCommentForCollege() throws Exception {
        Boolean isAdded = commentListDao.addCommentForCollege("广东","Mike","333",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(isAdded);
    }

    /**
     * 是否删除成功 true---删除成功  false---评论不存在
     * @throws Exception
     */
    @Test
    public void deleteCommentForSpots() throws Exception {
        Boolean isDeleted = commentListDao.deleteCommentForSpots("广东","佛山","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(2)));
        System.out.println(isDeleted);
    }

    /**
     * 是否删除成功 true---删除成功  false---评论不存在
     * @throws Exception
     */
    @Test
    public void deleteCommentForCollege() throws Exception {
        Boolean isDeleted = commentListDao.deleteCommentForCollege("广东","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(isDeleted);
    }

    /**
     *
     * @throws true---不可删除  false--可以删除
     */
    @Test
    public void spotsCommentDeletable() throws Exception {
        Boolean deletable = commentListDao.spotsCommentDeletable("广东","佛山","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(1)));
        System.out.println(deletable);
    }

    /**
     *
     * @throws true---不可删除  false--可以删除
     */
    @Test
    public void collegeCommentDeletable() throws Exception {
        Boolean deletable = commentListDao.collegeCommentDeletable("广东","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(deletable);
    }

}