package org.tvos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tvos.dto.ProvinceDto;
import org.tvos.entity.Province;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/mybatis-config.xml"})
public class ProvinceDaoTest {

    @Autowired
    ProvinceDao provinceDao;

    @Test
    public void getSpotsNum() throws Exception {
        List<Province> provinceList = provinceDao.getProvinceListForSpots();
        for(Province province:provinceList){
            System.out.println(provinceDao.getSpotsNum(province.getProvinceName()));
        }

    }

    @Test
    public void getCollegeNum() throws Exception {
        List<Province> provinceList = provinceDao.getProvinceListForCollege();
        for(Province province:provinceList){
            System.out.println(provinceDao.getCollegeNum(province.getProvinceName()));
        }
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void addSpotsNum() throws Exception {
        System.out.println(provinceDao.addSpotsNum());
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void subSpotsNum() throws Exception {
        System.out.println(provinceDao.subSpotsNum());
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void addCollegeNum() throws Exception {
        System.out.println(provinceDao.addCollegeNum());
    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void subCollegeNum() throws Exception {
        System.out.println(provinceDao.subCollegeNum());
    }


    /**
     * done
     * @throws Exception
     */
    @Test
    public void getProvinceListForSpots() throws Exception {
        List<Province> provinceList = provinceDao.getProvinceListForSpots();
        for(Province province:provinceList){
            System.out.println(province);
        }

    }

    /**
     * done
     * @throws Exception
     */
    @Test
    public void getProvinceListForCollege() throws Exception {
        List<Province> provinceList = provinceDao.getProvinceListForCollege();
        for(Province province:provinceList){
            System.out.println(province);
        }
    }

}