package org.tvos.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface QueryForTokenDao {

    String getToken(String marker);
    Boolean setToken(@Param(value = "marker") String marker, @Param(value = "token") String token);
    Boolean deleteToken(String marker);
    Date getOldestTime();
    Boolean deleteOldestToken();

}
