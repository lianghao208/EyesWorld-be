package org.tvos.service;

import org.springframework.stereotype.Service;
import org.tvos.dto.CityDto;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface CityService {
    List<CityDto> getCities(String provinceName);
}
