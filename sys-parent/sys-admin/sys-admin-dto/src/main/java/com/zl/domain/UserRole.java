package com.zl.domain;

import java.io.Serializable;

/**
 * 用户角色表
 * @author zhongliang
 */
public class UserRole implements Serializable {

    /**
     * 用户角色id
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 获取用户角色id
     * @return 用户角色id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户角色id
     * @param id 用户角色id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用色id
     * @return 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取用户id
     * @return 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
