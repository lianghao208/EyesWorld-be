package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class QueryForTokenDaoTest {
    @Autowired
    QueryForTokenDao queryForTokenDao;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getToken() throws Exception {
        String token = queryForTokenDao.getToken("123456");
        System.out.println(token);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void setToken() throws Exception {
        Boolean isSet = queryForTokenDao.setToken("123456","jaoifjoaifj");
        System.out.println(isSet);
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void deleteToken() throws Exception {
        Boolean isDel = queryForTokenDao.deleteToken("123456");
        System.out.println(isDel);
    }

}