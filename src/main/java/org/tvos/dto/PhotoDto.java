package org.tvos.dto;

import org.tvos.entity.Photo;

/**
 * Created by Administrator on 2017/7/26.
 */
public class PhotoDto{
    /**
     * "photoId":Number,
     "username":String,
     "photoName":String,
     "photoDescription":String,
     "url":String,
     "isLike":Boolean,
     "likeNum":Number,
     "time":Number
     "isLast": Boolean
     */
    private int photoId;
    private String username;
    private String photoName;
    private String photoDescription;
    private String url;
    private Boolean like;
    private int likeAmount;
    private int createTime;
    private Boolean last;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }
}
