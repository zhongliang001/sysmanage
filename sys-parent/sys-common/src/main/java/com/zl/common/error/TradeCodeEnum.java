package com.zl.common.error;

/**
 * @author zhongliang
 */
public enum TradeCodeEnum {

    //查询成功
    SUCCESS_QUERRY_CODE("000000", "查询成功"),
    // 新增成功
    SUCCESS_ADD_CODE("000001", "新增成功"),
    // 修改成功
    SUCCESS_UPDATE_CODE("000002", "修改成功"),
    // 删除成功
    SUCCESS_DELTE_CODE("000003", "删除成功"),
    // 新增失败
    FAILED_ADD_CODE("900001", "新增失败"),
    // 修改失败
    FAILED_UPDATE_CODE("900002", "修改失败"),
    // 删除成功
    FAILED_DELTE_CODE("900003", "删除失败"),
    // 重复新增
    FAILED_ADD_DUP_CODE("900004", "新增数据已经存在"),
    //传递参数有误
    ERROR_DATA("900000", "传递参数有误"),
    // 查询失败
    FAILED_QUERRY_CODE("999999", "查询失败"),
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

    TradeCodeEnum(String code, String message) {
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
