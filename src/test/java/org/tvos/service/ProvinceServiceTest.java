package org.tvos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dao.ProvinceDao;
import org.tvos.dto.ProvinceDto;
import org.tvos.entity.Province;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class ProvinceServiceTest {

    @Autowired
    ProvinceDao provinceDao;

    @Autowired
    ProvinceService provinceService;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getProvincesForSpots() throws Exception {
        List<ProvinceDto> provinceDtoList = provinceService.getProvincesForSpots();
        for(ProvinceDto provinceDto:provinceDtoList){
            System.out.println(provinceDto.getProvinceName());
        }
    }


    @Test
    public void getProvincesForCollege() throws Exception {
        List<ProvinceDto> provinceDtoList = provinceService.getProvincesForCollege();
        for(ProvinceDto provinceDto:provinceDtoList){
            System.out.println(provinceDto.getProvinceName());
        }
    }

}