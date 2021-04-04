package com.zl.common.error;
/**
 * @author zhongliang
 */
public enum ErrEnum {

    //查询成功
    SUCCESS_QUERRY_CODE("000000", "查询成功"),
    // 新增成功
    SUCCESS_ADD_CODE("000000","新增成功"),
    // 新增失败
    FAILED_ADD_CODE("999999", "新增失败"),
    // 登录失败
    FAILED_LOGIN_FAILED("000001","登录失败");
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
