package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.UserDao;
import org.tvos.dto.UserDto;
import org.tvos.dto.UserInfoDto;
import org.tvos.service.UserService;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public UserDto getUserDto(String cookie) {
        return null;
    }

    public UserInfoDto getUserInfoDto(String cookie, String username) {
        return null;
    }

    @Override
    public Boolean signup(String username, String password) {

        return userDao.insert(username,password);
    }

    @Override
    public Boolean updatePassword(String username, String password) {
        return userDao.updatePassword(username,password);
    }

    @Override
    public Boolean usernameUsed(String username) {
        return userDao.uniqueUsername(username);
    }
}
