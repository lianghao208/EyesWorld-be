package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tvos.dao.UserDao;

import java.util.Arrays;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String password=userDao.getPassword(s);
        if(password==null){
            throw new UsernameNotFoundException("username not found");
        }
        return new User(s,password, Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("user")}));

        //Spring Security 内置一UserDetails接口的实现类User
        //User有一构造方法：User(String username, String password, Collection<? extends GrantedAuthority> authorities),
        //其中authorities参数传入一由GrantedAuthority接口实现类对象组成的集合，GrantedAuthority有一实现类SimpleGrantedAuthority，
        //其唯一构造方法SimpleGrantedAuthority(String role)，由于数据表无权限字段，故统一使用user权限

    }
}
