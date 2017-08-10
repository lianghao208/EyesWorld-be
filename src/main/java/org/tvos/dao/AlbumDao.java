package org.tvos.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.tvos.entity.Album;

import java.util.List;

/**
 * 相册数据库DAO操作
 */
public interface AlbumDao {

    List<Album> getAlbumsFromSpots(@Param(value="provinceName")String provinceName,
                                   @Param(value="cityName") String cityName);

    List<Album> getAlbumsFromCollege(String provinceName);

    List<Album> getAlbumsFromRecommend();

    Boolean addAlbumFromSpots(@Param(value="provinceName")String provinceName,
                              @Param(value="cityName") String cityName,
                              @Param(value = "albumName") String albumName,
                              @Param(value = "url") String url);

    Boolean addAlbumFromCollege(@Param(value="provinceName")String provinceName,
                                @Param(value = "albumName") String albumName,
                                @Param(value = "url") String url);

    Boolean spotsLikeAdd(@Param(value = "albumName") String albumName);

    Boolean collegeLikeAdd(@Param(value = "albumName") String albumName);

    Boolean spotsLikeSub(@Param(value = "albumName") String albumName);

    Boolean collegeLikeSub(@Param(value = "albumName") String albumName);

    int getSpotsLikeAmount(@Param(value = "albumName") String albumName);

    int getCollegeLikeAmount(@Param(value = "albumName") String albumName);

    String getSpotsAlbumNameById(@Param(value="provinceName") String provinceName,
                                 @Param(value="cityName")String cityName,
                                 @Param(value = "albumId") Long albumId);

    String getCollegeAlbumNameById(@Param(value="provinceName") String provinceName,
                                   @Param(value = "albumId") Long albumId);

    /**
     * 增加景点相册浏览量
     * @param albumName
     * @return
     */
    Boolean spotsVisitAdd(@Param(value = "albumName") String albumName);

    /**
     * 增加高校相册浏览量
     * @param albumName
     * @return
     */
    Boolean collegeVisitAdd(@Param(value = "albumName") String albumName);

    /**
     * 获取景点相册访问量
     * @param albumName
     * @return
     */
    Integer getSpotsVisitAmount(@Param(value = "albumName") String albumName);

    /**
     * 获取高校相册访问量
     * @param albumName
     * @return
     */
    Integer getCollegeVisitAmount(@Param(value = "albumName") String albumName);
    /**
     * 暂时不需要
     * @param provinceName
     * @param cityName
     * @param albumName
     * @param url
     * @return
     */
    Boolean updateAlbumFromSpots(@Param(value="provinceName")String provinceName,
                                 @Param(value="cityName") String cityName,
                                 @Param(value = "albumName") String albumName,
                                 @Param(value = "url") String url);

    /**
     * 暂时不需要
     * @param provinceName
     * @param albumNam
     * @param url
     * @return
     */
    Boolean updateAlbumFromCollege(@Param(value="provinceName")String provinceName,
                                   @Param(value = "albumName") String albumNam,
                                   @Param(value = "url") String url);

    Boolean deleteAlbumFromSpots(@Param(value="provinceName")String provinceName,
                                 @Param(value="cityName") String cityName,
                                 @Param(value = "albumName") String albumName,
                                 @Param(value = "url") String url);

    Boolean deleteAlbumFromCollege(@Param(value="provinceName")String provinceName,
                                   @Param(value = "albumName") String albumName,
                                   @Param(value = "url") String url);
}
