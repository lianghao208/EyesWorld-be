package org.tvos.entity;

/**
 * Created by Administrator on 2017/7/26.
 */
public class Province {

    private String provinceName;
    private int spotNum;
    private int collegeNum;
    private int createTime;
    private int modificationTime;

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

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(int modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceName='" + provinceName + '\'' +
                ", spotNum=" + spotNum +
                ", collegeNum=" + collegeNum +
                ", createTime=" + createTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
