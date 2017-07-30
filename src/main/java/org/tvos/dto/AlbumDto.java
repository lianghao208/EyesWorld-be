package org.tvos.dto;

import org.tvos.entity.Album;

/**
 * 对实体类进行封装
 */
public class AlbumDto {
    private Long albumId;
    private String albumName;
    private Long visitAmount;
    private Long likeAmount;
    private String url;

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
}
