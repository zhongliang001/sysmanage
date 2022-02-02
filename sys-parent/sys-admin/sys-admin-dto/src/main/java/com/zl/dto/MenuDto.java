package com.zl.dto;

import com.zl.domain.Menu;

import java.util.List;

/**
 * @author zhongliang
 */
public class MenuDto extends Menu {

    /**
     * 子菜单
     */
    List<Menu> children;

    /**
     * 菜单操作权限
     */
    List<ActionDto> actionDtos;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<ActionDto> getActionDtos() {
        return actionDtos;
    }

    public void setActionDtos(List<ActionDto> actionDtos) {
        this.actionDtos = actionDtos;
    }
}
