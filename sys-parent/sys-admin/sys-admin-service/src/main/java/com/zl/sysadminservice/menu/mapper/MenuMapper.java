package com.zl.sysadminservice.menu.mapper;

import com.zl.domain.Menu;

import java.util.List;
import java.util.Map;

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

    /**
     * 菜单查查询
     * @param condition 查询条件
     * @return 菜单集合
     */
    List<Menu> select(Map<String, Object> condition);
}
