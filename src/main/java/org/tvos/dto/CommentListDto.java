package org.tvos.dto;

import org.tvos.entity.CommentList;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CommentListDto{

    private Long commentId;
    private String username;
    private String content;
    private Integer modificationTime;


    public Long getCommentId() {
        return commentId;
    }


    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Integer getModificationTime() {
        return modificationTime;
    }


    public void setModificationTime(Integer modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "CommentListDto{" +
                "commentId=" + commentId +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
