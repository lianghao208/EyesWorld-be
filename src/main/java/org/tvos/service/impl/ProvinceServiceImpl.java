package org.tvos.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.ProvinceDao;
import org.tvos.dao.UserDao;
import org.tvos.dto.CityDto;
import org.tvos.dto.ProvinceDto;
import org.tvos.entity.Province;
import org.tvos.service.ProvinceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {


    @Autowired
    ProvinceDao provinceDao;

    /**
     * TODO 访问Dao层拿景点对应的省份数据
     * @return
     */
    public List<ProvinceDto> getProvincesForSpots() {
        List<ProvinceDto> provinceDtoList = new ArrayList<ProvinceDto>();
        List<Province> provinceList = provinceDao.getProvinceListForSpots();
        System.out.println(provinceList);
        //将 provinceList 转换成 provinceDtoList
        for(Province p: provinceList){
            ProvinceDto provinceDto = new ProvinceDto();
            provinceDto.setProvinceName(p.getProvinceName());
            provinceDto.setSpotNum(p.getSpotNum());
            provinceDto.setCollegeNum(p.getCollegeNum());
            provinceDtoList.add(provinceDto);

        }
        System.out.println(provinceDtoList);
        return provinceDtoList;
    }

    /**
     * TODO 访问Dao层拿高校对应的省份数据
     * @return
     */
    public List<ProvinceDto> getProvincesForCollege() {
        List<ProvinceDto> provinceDtoList = new ArrayList<ProvinceDto>();
        List<Province> provinceList = provinceDao.getProvinceListForCollege();
        //将 provinceList 转换成 provinceDtoList
        for(Province province: provinceList){
            ProvinceDto provinceDto = new ProvinceDto();
            provinceDto.setProvinceName(province.getProvinceName());
            provinceDtoList.add(provinceDto);
        }
        return provinceDtoList;
    }


}
