package org.tvos.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dao.PhotoDao;
import org.tvos.dao.ProvinceDao;
import org.tvos.dto.PhotoDto;
import org.tvos.entity.Photo;
import org.tvos.entity.Province;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class RedisDaoTest {


    @Autowired
    private RedisDao redisDao;

    @Autowired
    private ProvinceDao provinceDao;

    @Test
    public void getProvinceListForSpots() throws Exception {
    }

    @Test
    public void putProvinceListForSpots() throws Exception {
        List<Province> provinceList = redisDao.getProvinceListForSpots();
        if(provinceList == null){
            provinceList = provinceDao.getProvinceListForSpots();
            System.out.println(provinceList);
            if(provinceList != null){//写入redis缓存
                String result = redisDao.putProvinceListForSpots(provinceList);
                System.out.println(result);
                provinceList = redisDao.getProvinceListForSpots();
                System.out.println(provinceList);
            }
        }
    }



}