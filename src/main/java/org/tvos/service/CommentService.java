package org.tvos.service;


import org.springframework.stereotype.Service;
import org.tvos.dto.CommentListDto;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface CommentService {
    List<CommentListDto> getCommentListFromSpots(String provinceName, String cityName, Long AlbumId, Long PhotoId);

    List<CommentListDto> getCommentListFromCollege(String provinceName, Long AlbumId, Long PhotoId);

    Boolean addCommentForSpots(String provinceName,
                               String cityName,
                               String username,
                               String content,
                               Long albumId,
                               Long photoId);

    Boolean addCommentForCollege(String provinceName,
                               String username,
                               String content,
                               Long albumId,
                               Long photoId);

    Boolean deleteCommentForSpots(String provinceName,
                                  String cityName,
                                  String username,
                                  Long albumId,
                                  Long photoId,
                                  Long commentId);

    Boolean deleteCommentForCollege(String provinceName,
                                    String username,
                                    Long albumId,
                                    Long photoId,
                                    Long commentId);

    Boolean spotsCommentDeletable(String provinceName,
                                  String cityName,
                                  String username,
                                  Long albumId,
                                  Long photoId,
                                  Long commentId);

    Boolean collegeCommentDeletable(String provinceName,
                                    String username,
                                    Long albumId,
                                    Long photoId,
                                    Long commentId);
}
