package com.zl.common.dto;

import java.io.Serializable;

/**
 * @author zhongliang
 * @version 1.0.1
 * @param <Data>
 */
public class ResultDto<Data> implements Serializable {

    private Data data;

    private String code;

    private String msg;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
