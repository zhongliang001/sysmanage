package com.zl.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体类
 * @author zhongliang
 * @since 1.0
 */
public class SMenu implements Serializable {
    private String id;
    private String name;
    private String path;
    private String filePath;
    private String parentId;
    private List<SMenu> children;

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

    public List<SMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SMenu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SMenu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", filePath='" + filePath + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }
}
