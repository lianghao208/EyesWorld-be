package org.tvos.dto;

import org.tvos.entity.Province;

/**
 * Created by Administrator on 2017/7/26.
 */
public class ProvinceDto {

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getSpotNum() {
        return spotNum;
    }

    public void setSpotNum(int spotNum) {
        this.spotNum = spotNum;
    }

    public int getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(int collegeNum) {
        this.collegeNum = collegeNum;
    }

    private String provinceName;
    private int spotNum;
    private int collegeNum;

}
