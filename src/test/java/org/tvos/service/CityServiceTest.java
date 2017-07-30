package org.tvos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dto.CityDto;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class CityServiceTest {

    @Autowired
    CityService cityService;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getCities() throws Exception {
        List<CityDto> cityDtoList =  cityService.getCities("GD");
        System.out.println(cityDtoList);
    }

}