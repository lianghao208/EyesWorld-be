package org.tvos.dao;

import org.tvos.entity.City;
import org.tvos.entity.Province;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface CityDao {

    /**
     * 得到城市列表
     * @return
     */
    List<City> getCityList(String ProvinceName);

    /**
     * 得到城市的相册数
     * @return
     */
    int getSpotsNum(String cityName);

    Boolean addSpotsNum();

    Boolean subSpotsNum();
}
