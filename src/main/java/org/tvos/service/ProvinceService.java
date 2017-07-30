package org.tvos.service;

import org.tvos.dto.CityDto;
import org.tvos.dto.ProvinceDto;

import java.util.List;

/**
 * 省份接口
 */
public interface ProvinceService {

    /**
     * 获取省对应的城市
     * @return
     */
    List<ProvinceDto> getProvincesForSpots();

    List<ProvinceDto> getProvincesForCollege();
}
