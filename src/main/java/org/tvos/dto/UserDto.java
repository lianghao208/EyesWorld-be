package org.tvos.dto;

import org.tvos.entity.User;

/**
 * Created by Administrator on 2017/7/26.
 */
public class UserDto extends User{
    //登陆状态：true为已登录，false为未登录
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
