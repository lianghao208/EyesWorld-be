package org.tvos.controller.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tvos.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/userManagement")
public class UserManagerController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/ModifyPassword", method = RequestMethod.POST)
    public Map<String, Boolean> modifyPassword(HttpServletRequest request) {

        Map<String, Boolean> modifySuccessMap = new HashMap<String, Boolean>();
        String username = getCurrentUserName();
        String oldPassword = request.getParameter("oldPassword");//旧密码
        String newPassword = request.getParameter("newPassword");//新密码
        //数据库中修改用户密码
        Boolean modifySuccess = userService.modifyPassword(username, oldPassword, newPassword);
        modifySuccessMap.put("success", modifySuccess);
        return modifySuccessMap;
    }

    /**
     * 获取用户名
     *
     * @return
     */
    private String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return null;
        } else {
            return ((UserDetails) auth.getPrincipal()).getUsername();
        }
    }
}
