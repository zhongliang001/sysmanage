package com.zl.domain;

import java.io.Serializable;

/**
 * 角色对象
 * @author zhongliang
 */
public class Role implements Serializable {

    /**
     * 角色id
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色描述
     */
    private String remark;

    /**
     * 获取角色id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置角色id
     * @param id 角色id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色名
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名
     * @param name 角色名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色描述
     * @return 角色描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置角色描述
     * @param remark 角色描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
