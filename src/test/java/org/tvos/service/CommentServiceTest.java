package org.tvos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dao.CommentListDao;
import org.tvos.dto.CommentListDto;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class CommentServiceTest {

    @Autowired
    CommentService commentService;
    @Test
    public void getCommentListFromSpots() throws Exception {
        List<CommentListDto> commentListDtos = commentService.getCommentListFromSpots("广东","潮州",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(commentListDtos);
    }

    @Test
    public void getCommentListFromCollege() throws Exception {
        List<CommentListDto> commentListDtos = commentService.getCommentListFromCollege("广东",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(commentListDtos);
    }

    @Test
    public void addCommentForSpots() throws Exception {
        Boolean isAdded= commentService.addCommentForSpots("广东","潮州","tmh","123121414",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(isAdded);
    }

    @Test
    public void addCommentForCollege() throws Exception {
        Boolean isAdded= commentService.addCommentForCollege("广东","Mike","123121414",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)));
        System.out.println(isAdded);
    }

    @Test
    public void deleteCommentForSpots() throws Exception {
        Boolean isDeleted= commentService.deleteCommentForSpots("广东","佛山","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(3)));
        System.out.println(isDeleted);
    }

    @Test
    public void deleteCommentForCollege() throws Exception {
        Boolean isDeleted= commentService.deleteCommentForCollege("广东","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(7)));
        System.out.println(isDeleted);
    }

    /**
     *
     * @throws true---不可删除，评论不存在   false---可删除，评论存在
     */
    @Test
    public void spotsCommentDeletable() throws Exception {
        Boolean isDeleted= commentService.spotsCommentDeletable("广东","佛山","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(8)));
        System.out.println(isDeleted);
    }

    @Test
    public void collegeCommentDeletable() throws Exception {
        Boolean isDeleted= commentService.collegeCommentDeletable("广东","Mike",Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(0)),Long.valueOf(String.valueOf(9)));
        System.out.println(isDeleted);
    }

}