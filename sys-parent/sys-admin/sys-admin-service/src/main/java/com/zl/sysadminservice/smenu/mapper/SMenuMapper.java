package com.zl.sysadminservice.smenu.mapper;

import com.zl.domain.SMenu;

import java.util.List;

/**
 * @author zhongliang
 */
public interface SMenuMapper {

    /**
     * 根据父节点查询菜单
     * @param parentId 父节点id
     * @return 菜单集合
     */
    List<SMenu> selectSMenu(String parentId);
}
