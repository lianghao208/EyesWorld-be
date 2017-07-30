package org.tvos.service;

import org.tvos.dto.UserDto;
import org.tvos.dto.UserInfoDto;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface UserService {
    UserDto getUserDto(String cookie);

    UserInfoDto getUserInfoDto(String cookie, String username);
}
