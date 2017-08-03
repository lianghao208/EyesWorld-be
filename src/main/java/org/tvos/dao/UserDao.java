package org.tvos.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface UserDao {

    /**
     * 通过用户名获取密码
     * @param username
     * @return
     */
    String getPassword(String username);

    String getUsername(Long userId);

    Boolean uniqueUsername(String username);

    Boolean insert(@Param(value = "username") String username,@Param(value = "password") String password);

    Boolean updatePassword(@Param(value = "username") String username,@Param(value = "password") String password);
}
