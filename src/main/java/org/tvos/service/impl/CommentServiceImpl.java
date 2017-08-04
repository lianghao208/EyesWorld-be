package org.tvos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.CommentListDao;
import org.tvos.dao.UserDao;
import org.tvos.dto.CommentListDto;
import org.tvos.entity.CommentList;
import org.tvos.service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentListDao commentListDao;

    @Autowired
    UserDao userDao;
    @Override
    public List<CommentListDto> getCommentListFromSpots(String provinceName, String cityName, Long AlbumId, Long PhotoId) {
        List<CommentList> commentListDaoList =  commentListDao.getPhotoCommentListFromSpots(provinceName,cityName,AlbumId,PhotoId);
        List<CommentListDto> commentListDtoList = new ArrayList<CommentListDto>();
        for(CommentList c:commentListDaoList){
            CommentListDto commentListDto = new CommentListDto();
            System.out.println(c);
            System.out.println(c.getUserId());
            commentListDto.setCommentId(c.getCommentId());
            commentListDto.setUsername(getUsername(c.getUserId()));
            commentListDto.setContent(c.getContent());
            commentListDto.setModificationTime(c.getModificationTime());
            commentListDtoList.add(commentListDto);
        }

        return commentListDtoList;
    }

    @Override
    public List<CommentListDto> getCommentListFromCollege(String provinceName, Long AlbumId, Long PhotoId) {
        List<CommentList> commentListDaoList =  commentListDao.getPhotoCommentListFromCollege(provinceName,AlbumId,PhotoId);
        List<CommentListDto> commentListDtoList = new ArrayList<CommentListDto>();


        for(CommentList c:commentListDaoList){
            CommentListDto commentListDto = new CommentListDto();
            commentListDto.setCommentId(c.getCommentId());

            commentListDto.setUsername(getUsername(c.getUserId()));
            commentListDto.setContent(c.getContent());
            commentListDto.setModificationTime(c.getModificationTime());
            commentListDtoList.add(commentListDto);
        }

        return commentListDtoList;
    }



    @Override
    public Boolean addCommentForSpots(String provinceName, String cityName, String username, String content, Long albumId, Long photoId) {

        return commentListDao.addCommentForSpots(provinceName,cityName,username,content,albumId,photoId);
    }

    @Override
    public Boolean addCommentForCollege(String provinceName, String username, String content, Long albumId, Long photoId) {
        return commentListDao.addCommentForCollege(provinceName,username,content,albumId,photoId);
    }

    @Override
    public Boolean deleteCommentForSpots(String provinceName, String cityName, String username, Long albumId, Long photoId, Long commentId) {
        return commentListDao.deleteCommentForSpots(provinceName,cityName,username,albumId,photoId,commentId);
    }

    @Override
    public Boolean deleteCommentForCollege(String provinceName, String username, Long albumId, Long photoId, Long commentId) {
        return commentListDao.deleteCommentForCollege(provinceName,username,albumId,photoId,commentId);
    }

    @Override
    public Boolean spotsCommentDeletable(String provinceName, String cityName, String username, Long albumId, Long photoId, Long commentId) {
        return commentListDao.spotsCommentDeletable(provinceName,cityName,username,albumId,photoId,commentId);
    }

    @Override
    public Boolean collegeCommentDeletable(String provinceName, String username, Long albumId, Long photoId, Long commentId) {
        return commentListDao.collegeCommentDeletable(provinceName,username,albumId,photoId,commentId);
    }


    /**
     *
     * @param userId
     * @return
     */
    private String getUsername(Long userId){
        return userDao.getUsername(userId);

    }

}
