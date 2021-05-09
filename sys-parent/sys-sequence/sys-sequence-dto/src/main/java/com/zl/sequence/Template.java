package com.zl.sequence;

import java.io.Serializable;

/**
 * <p>
 *     序列模板类
 * </p>
 * @author zhongliang
 */
public class Template implements Serializable {

    /**
     * 模板编号
     */
    private String id;

    /**
     * 模板名
     */
    private String name;

    /**
     * 模板
     */
    private String temp;

    /**
     * 序列起始值
     */
    private Integer start;

    /**
     *  序列结束值
     */
    private Integer end;

    /**
     * 序列长度
     */
    private Integer length;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
