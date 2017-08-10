package org.tvos.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class City {

    private String cityName;
    private int provinceId;
    private int spotNum;
    private int createTime;
    private Date modificationTime;


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getSpotNum() {
        return spotNum;
    }

    public void setSpotNum(int spotNum) {
        this.spotNum = spotNum;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", provinceId=" + provinceId +
                ", spotNum=" + spotNum +
                ", createTime=" + createTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
