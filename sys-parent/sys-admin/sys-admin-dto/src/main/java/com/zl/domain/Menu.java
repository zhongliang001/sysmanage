package com.zl.domain;

import java.io.Serializable;
import java.util.List;

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
    private List<Menu> children;
    private List<Action> actions;

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

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", filePath='" + filePath + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                ", actions=" + actions +
                '}';
    }
}
