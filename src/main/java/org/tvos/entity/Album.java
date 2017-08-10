package org.tvos.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class Album {
    private Long albumId;
    private String albumName;
    private Long provinceId;
    private Long cityId;
    private Long visitAmount;
    private Long likeAmount;
    private String url;
    private int createTime;
    private Date modificationTime;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getVisitAmount() {
        return visitAmount;
    }

    public void setVisitAmount(Long visitAmount) {
        this.visitAmount = visitAmount;
    }

    public Long getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(Long likeAmount) {
        this.likeAmount = likeAmount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }
}
