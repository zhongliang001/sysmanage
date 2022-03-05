package com.zl.domain;

import java.io.Serializable;

/**
 * 菜单实体类
 *
 * @author zhongliang
 * @since 1.0
 */
public class Menu implements Serializable {
    private String menuId;
    private String menuName;
    private String path;
    private String filePath;
    private String parentId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + menuId + '\'' +
                ", name='" + menuName + '\'' +
                ", path='" + path + '\'' +
                ", filePath='" + filePath + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
