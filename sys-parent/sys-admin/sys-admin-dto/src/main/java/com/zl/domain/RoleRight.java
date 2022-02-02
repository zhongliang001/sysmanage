package com.zl.domain;

/**
 * Table: role_right
 */
public class RoleRight {
    /**
     * Column: id
     * Type: VARCHAR(10)
     * Remark: 角色权限id
     */
    private String id;

    /**
     * Column: role_id
     * Type: VARCHAR(10)
     * Remark: 角色id
     */
    private String roleId;

    /**
     * Column: action_id
     * Type: VARCHAR(10)
     * Remark: 操作id
     */
    private String actionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId == null ? null : actionId.trim();
    }
}