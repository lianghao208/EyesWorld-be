package org.tvos.controller.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tvos.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/2.
 */
@RestController
@RequestMapping("/signup")
public class SingupController {

    @Autowired
    UserService userService;

    /**
     * 注册请求
     * @param request
     * @return
     */
    @RequestMapping(value = "/request",method= RequestMethod.POST)
    public Map<String,Boolean> singup(HttpServletRequest request){

        Map<String,Boolean> signupSuccessMap = new HashMap<String, Boolean>();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        if(!userService.usernameUsed(username)){//判断用户名是否重复
            signupSuccessMap.put("success",false);
            return signupSuccessMap;
        }
        //将用户名密码插入数据库
        Boolean signupSuccess = userService.signup(username,password);
        signupSuccessMap.put("success",signupSuccess);
        return signupSuccessMap;
    }

    /**
     * 判断用户名是否重复
     * @param username
     * @return
     */
    @RequestMapping(value = "/check/{username}",method= RequestMethod.GET)
    public Map<String,Boolean>  nameUsed(@PathVariable("username") String username){

        //TODO 查询数据库用户名是否存在并返回Boolean值
        Boolean usernameUsed = userService.usernameUsed(username);
        Map<String,Boolean> usernameUsedMap = new HashMap<String, Boolean>();
        usernameUsedMap.put("nameUsed",usernameUsed);
        return usernameUsedMap;
    }

}
