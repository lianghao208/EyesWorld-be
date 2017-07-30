package org.tvos.constant;

/**
 * Created by Administrator on 2017/7/26.
 */
public enum PageCodeEnum {
    ADD_SUCCESS(1000,"新增成功!"),
    ADD_FAIL(1001,"新增失败!"),;

    private Integer code;
    private String msg;

    public static final String KEY="pageCode";


    PageCodeEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
