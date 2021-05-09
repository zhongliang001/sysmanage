package com.zl.sysadminservice.sysmenu.mapper;

import com.zl.domain.SysMenu;

import java.util.List;

/**
 * @author zhongliang
 */
public interface SysMenuMapper {

    /**
     * 根据父节点查询菜单
     *
     * @param parentId 父节点id
     * @return 菜单集合
     */
    List<SysMenu> selectSysMenu(String parentId);
}
