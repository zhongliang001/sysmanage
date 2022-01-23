package com.zl.domain;

import java.io.Serializable;

/**
 * 菜单实体类
 *
 * @author zhongliang
 * @since 1.0
 */
public class Menu implements Serializable {
    private String id;
    private String name;
    private String path;
    private String filePath;
    private String parentId;

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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", filePath='" + filePath + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
