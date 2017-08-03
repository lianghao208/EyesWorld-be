package org.tvos.entity;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CommentList {
    private Long commentId;
    private Long photoId;
    private Long userId;
    private String content;
    private Integer createTime;
    private Integer modificationTime;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Integer modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "CommentList{" +
                "commentId=" + commentId +
                ", photoId=" + photoId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
