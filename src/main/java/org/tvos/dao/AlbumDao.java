package org.tvos.dao;

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
