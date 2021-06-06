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

    /**
     * 菜单新增
     * @param menu 新增的菜单
     * @return 新增的条数
     */
    int save(Menu menu);

    /**
     * 修改菜单
     * @param menu 修改的菜单
     * @return 修改的条数
     */
    int update(Menu menu);

    /**
     * 删除菜单
     * @param id 菜单编号
     * @return 返回删除菜单条数
     */
    int delete (String id);

}
