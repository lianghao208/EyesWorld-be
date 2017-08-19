package org.tvos.dto;

import org.tvos.entity.CommentList;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CommentListDto{

    private Long commentId;
    private String username;
    private String content;
    private Date modificationTime;


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


    public Date getModificationTime() {
        return modificationTime;
    }


    public void setModificationTime(Date modificationTime) {
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
