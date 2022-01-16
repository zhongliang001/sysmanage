package com.zl.domain;

import java.io.Serializable;

/**
 * Table: action
 * @author zhongliang
 */
public class Action implements Serializable {
    /**
     * Column: id
     * Type: VARCHAR(10)
     * Remark: 操作id
     */
    private String id;

    /**
     * Column: name
     * Type: VARCHAR(20)
     * Remark: 操作名称
     */
    private String name;

    /**
     * Column: oper
     * Type: VARCHAR(20)
     * Remark: 操作
     */
    private String oper;

    /**
     * Column: menu_id
     * Type: VARCHAR(32)
     * Remark: 菜单id
     */
    private String menuId;

    /**
     * Column: menu_name
     * Type: VARCHAR(64)
     * Remark: 菜单name
     */
    private String menuName;

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

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}