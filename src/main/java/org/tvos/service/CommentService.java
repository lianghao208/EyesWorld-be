package org.tvos.service;


import org.springframework.stereotype.Service;
import org.tvos.dto.CommentListDto;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface CommentService {
    CommentListDto getCommentListDto(String provinceName, String cityName, Long AlbumId, Long PhotoId);
}
