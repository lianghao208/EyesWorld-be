package org.tvos.dao;

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

    Boolean uniqueUsername(String username);
}
