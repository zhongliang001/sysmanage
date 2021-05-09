package com.zl.syssequence.format;

/**
 * @author zhongliang
 */
public enum FormatEnum {
    // 日期格式
    D(DateFormat.class),
    // 序列号
    S(SequceFormat.class),
    // uuid
    U(UUIDFormat.class);

    private Class<? extends FormatInterface> formatInterface;

    FormatEnum(Class<? extends FormatInterface> formatInterface){
        this.formatInterface = formatInterface;
    }

    @SuppressWarnings("unchecked")
    public  Class<FormatInterface> getFormat(){
        return (Class<FormatInterface>) this.formatInterface;
    }

    public  void setFormat(Class<? extends FormatInterface> formatInterface){
        this.formatInterface = formatInterface;
    }

}
