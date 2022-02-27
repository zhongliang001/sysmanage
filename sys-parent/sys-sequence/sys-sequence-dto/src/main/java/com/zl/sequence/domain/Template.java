package com.zl.sequence.domain;

/**
 * Table: template
 */
public class Template {
    /**
     * Column: id
     * Type: VARCHAR(32)
     * Remark: 主键id
     */
    private String id;

    /**
     * Column: name
     * Type: VARCHAR(32)
     * Remark: 模板名
     */
    private String name;

    /**
     * Column: temp
     * Type: VARCHAR(64)
     * Remark: 模板
     */
    private String temp;

    /**
     * Column: start
     * Type: INT
     * Remark: 起始数据
     */
    private Integer start;

    /**
     * Column: end
     * Type: INT
     * Remark: 结束数据
     */
    private Integer end;

    /**
     * Column: length
     * Type: VARCHAR(20)
     * Remark: 长度
     */
    private String length;

    /**
     * Column: create_time
     * Type: VARCHAR(20)
     * Remark: 创建时间
     */
    private String createTime;

    /**
     * Column: create_user
     * Type: VARCHAR(32)
     * Remark: 创建人
     */
    private String createUser;

    /**
     * Column: update_time
     * Type: VARCHAR(20)
     * Remark: 更新时间
     */
    private String updateTime;

    /**
     * Column: update_user
     * Type: VARCHAR(32)
     * Remark: 更新人
     */
    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}
