package com.zl.sysadminservice.menu.mapper;

import com.zl.domain.Menu;

import java.util.List;

/**
 * @author zhongliang
 */
public interface MenuMapper {

    /**
     * 根据父节点查询菜单
     *
     * @param parentId 父节点id
     * @return 菜单集合
     */
    List<Menu> selectMenu(String parentId);
}
