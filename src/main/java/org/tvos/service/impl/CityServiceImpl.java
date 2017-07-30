package org.tvos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.CityDao;
import org.tvos.dto.CityDto;
import org.tvos.entity.City;
import org.tvos.service.CityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;
    /**
     * TODO 访问Dao层拿城市数据
     * @return
     */
    public List<CityDto> getCities(String provinceName) {
        List<CityDto> cityDtoList = new ArrayList<CityDto>();
        List<City> cityList = cityDao.getCityList(provinceName);
        //将 provinceList 转换成 provinceDtoList
        for(City c: cityList){
            CityDto cityDto = new CityDto();
            cityDto.setCityName(c.getCityName());
            cityDto.setSpotNum(c.getSpotNum());
            cityDtoList.add(cityDto);

        }
        return cityDtoList;
    }
}
