package org.tvos.dao;

import org.apache.ibatis.annotations.Param;
import org.tvos.dto.ProvinceDto;
import org.tvos.entity.Province;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface ProvinceDao {

    /**
     * 通过各个城市的相册数得到对应的省份名字
     * @return
     */
    List<Province> getProvinceListForSpots();

    /**
     * 通过各个省份的高校相册数得到对应的省份名字
     * @return
     */
    List<Province> getProvinceListForCollege();

    int getSpotsNum(String provinceName);

    int getCollegeNum(String provinceName);

    Boolean addSpotsNum(@Param(value="provinceName") String provinceName,@Param(value="cityName") String cityName);

    Boolean subSpotsNum(@Param(value="provinceName") String provinceName,@Param(value="cityName")String cityName);

    Boolean addCollegeNum(@Param(value="provinceName") String provinceName);

    Boolean subCollegeNum(@Param(value="provinceName")String provinceName);
}
