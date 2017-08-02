package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.entity.City;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class CityDaoTest {

    @Autowired
    CityDao cityDao;

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getCityList() throws Exception {
        List<City> cityList = cityDao.getCityList("GD");
        for(City city:cityList){
            System.out.println(city);
        }
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getSpotsNum() throws Exception {
        List<City> cityList = cityDao.getCityList("GD");
        for(City city:cityList){
            System.out.println(cityDao.getSpotsNum(city.getCityName()));
        }
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void addSpotsNum() throws Exception {
        System.out.println(cityDao.addSpotsNum("珠海"));
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void subSpotsNum() throws Exception {
        System.out.println(cityDao.subSpotsNum("珠海"));
    }

}