package com.zl.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhongliang
 */
public class RoleMenuRightDto implements Serializable {

    /**
     * 菜单权限
     */
    private List<MenuRightDto> menuRightDtos;

    /**
     * 角色id
     */
    private String roleId;

    public List<MenuRightDto> getMenuRightDtos() {
        return menuRightDtos;
    }

    public void setMenuRightDtos(List<MenuRightDto> menuRightDtos) {
        this.menuRightDtos = menuRightDtos;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
