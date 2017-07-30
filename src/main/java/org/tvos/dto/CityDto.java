package org.tvos.dto;

import org.tvos.entity.City;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CityDto {
    private String cityName;
    private int spotNum;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getSpotNum() {
        return spotNum;
    }

    public void setSpotNum(int spotNum) {
        this.spotNum = spotNum;
    }
}
