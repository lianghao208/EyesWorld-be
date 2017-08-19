package org.tvos.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvos.dao.ProvinceDao;
import org.tvos.dao.UserDao;
import org.tvos.dao.cache.RedisDao;
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
    private ProvinceDao provinceDao;

    @Autowired
    private RedisDao redisDao;

    /**
     * TODO 高并发优化点：访问Redis缓存
     * @return
     */
    public List<ProvinceDto> getProvincesForSpots() {
        //Redis缓存优化
        List<Province> provinceList = getProvinceCacheFromRedis();
        List<ProvinceDto> provinceDtoList = new ArrayList<ProvinceDto>();
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
     * TODO 高并发优化点：访问Redis缓存
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

    /**
     * 读取Redis缓存
     * @return
     */
    private List<Province> getProvinceCacheFromRedis(){
        //1.访问redis
        List<Province> provinceList = redisDao.getProvinceListForSpots();
        if(provinceList == null){
            provinceList = provinceDao.getProvinceListForSpots();
            if(provinceList == null){
                //图片不存在，返回空对象
                return new ArrayList<Province>();
            }else {
                redisDao.putProvinceListForSpots(provinceList);
            }
        }
        return provinceList;
    }

}
