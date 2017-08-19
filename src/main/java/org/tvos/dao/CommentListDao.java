package org.tvos.dao;

import org.apache.ibatis.annotations.Param;
import org.tvos.entity.CommentList;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface CommentListDao {


    /**
     * 获取用户图片评论
     * @param photoName
     * @return
     */
    List<CommentList> getCommentListFromUser(String photoName);

    /**
     * 得到景点图片评论
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    List<CommentList> getPhotoCommentListFromSpots(@Param(value = "provinceName") String provinceName,
                                                   @Param(value = "cityName")String cityName,
                                                   @Param(value = "albumId")Long albumId,
                                                   @Param(value = "photoId")Long photoId);

    /**
     * 得到高校图片评论
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    List<CommentList> getPhotoCommentListFromCollege(@Param(value = "provinceName") String provinceName,
                                                     @Param(value = "albumId")Long albumId,
                                                     @Param(value = "photoId")Long photoId);

    /**
     * 添加景点评论
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    Boolean addCommentForSpots(@Param(value = "provinceName") String provinceName,
                               @Param(value = "cityName")String cityName,
                               @Param(value = "username")String username,
                               @Param(value = "content")String content,
                               @Param(value = "albumId")Long albumId,
                               @Param(value = "photoId")Long photoId);

    /**
     * 添加高校评论
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    Boolean addCommentForCollege(@Param(value = "provinceName") String provinceName,
                                 @Param(value = "username")String username,
                                 @Param(value = "content")String content,
                                 @Param(value = "albumId")Long albumId,
                                 @Param(value = "photoId")Long photoId);

    /**
     * 删除景点评论
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    Boolean deleteCommentForSpots(@Param(value = "provinceName") String provinceName,
                                  @Param(value = "cityName")String cityName,
                                  @Param(value = "username")String username,
                                  @Param(value = "albumId")Long albumId,
                                  @Param(value = "photoId") Long photoId,
                                  @Param(value = "commentId") Long commentId);

    /**
     * 删除高校评论
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    Boolean deleteCommentForCollege(@Param(value = "provinceName") String provinceName,
                                    @Param(value = "username")String username,
                                    @Param(value = "albumId")Long albumId,
                                    @Param(value = "photoId")Long photoId,
                                    @Param(value = "commentId") Long commentId);

    /**
     * 删除用户图片评论
     * @param username
     * @param commentId
     * @return
     */
    Boolean deleteCommentForUser(@Param(value = "username")String username,
                                 @Param(value = "commentId") Long commentId);
    /**
     * 判断景点评论是否可删除
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    Boolean spotsCommentDeletable(@Param(value = "provinceName") String provinceName,
                                  @Param(value = "cityName")String cityName,
                                  @Param(value = "username")String username,
                                  @Param(value = "albumId")Long albumId,
                                  @Param(value = "photoId")Long photoId,
                                  @Param(value = "commentId") Long commentId);

    /**
     * 判断高校评论是否可删除
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    Boolean collegeCommentDeletable(@Param(value = "provinceName") String provinceName,
                                    @Param(value = "username")String username,
                                    @Param(value = "albumId")Long albumId,
                                    @Param(value = "photoId")Long photoId,
                                    @Param(value = "commentId") Long commentId);

    /**用户图片是否可删除
     * @return
     */
    Boolean userCommentDeletable( @Param(value = "username") String username,
                                  @Param(value = "commentId") Long commentId);



}
