package com.zl.common.error;

/**
 * @author zhongliang
 */
public enum ErrEnum {

    //查询成功
    SUCCESS_QUERRY_CODE("000000", "查询成功"),
    // 新增成功
    SUCCESS_ADD_CODE("000000", "新增成功"),
    // 新增失败
    FAILED_ADD_CODE("999999", "新增失败"),
    // 登录失败
    FAILED_LOGIN_CODE("000001", "登录失败"),
    // 格式化失败
    FAILED_FORMAT_CODE("100001", "格式化失败"),
    //序列模板不存在
    NO_TEMPLATE_CODE("100002", "序列模板不存在"),
    //序列名为空
    SEQUENCE_NAME_NULL_CODE("100003", "序列名为空");
    private String code;

    private String message;

    ErrEnum(String code, String message) {
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
