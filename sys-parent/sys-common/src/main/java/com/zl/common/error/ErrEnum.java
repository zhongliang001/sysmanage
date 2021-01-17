package com.zl.common.error;

public enum ErrEnum {

    SUCCESS_QUERRY_CODE("000000", "查询成功"),
    SUCCESS_ADD_CODE("000000","新增成功"),
    FAILED_ADD_CODE("999999", "新增失败");
    private String code;

    private String message;

    ErrEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
