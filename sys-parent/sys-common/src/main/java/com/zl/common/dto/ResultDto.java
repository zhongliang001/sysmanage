package com.zl.common.dto;

import java.io.Serializable;

/**
 * @author zhongliang
 * @version 1.0.1
 * @param <T>
 */
public class ResultDto<T> implements Serializable {

    private T t;

    private int code;

    private String msg;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
                "t=" + t +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
