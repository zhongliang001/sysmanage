package com.zl.sysadminservice.menu.mapper;

import com.zl.domain.Menu;
import com.zl.dto.MenuDto;
import com.zl.dto.MenuRightDto;

import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
public interface MenuMapper {

    /**
     * 根据父节点查询菜单
     *
     * @param map 查詢條件
     * @return 菜单集合
     */
    List<MenuDto> selectMenu(Map<String, Object> map);

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

    /**
     * 根据角色查询角色的菜单权限
     * @param condition 查询条件呢
     * @return 菜单权限
     */
    List<MenuRightDto> selectByRole(Map<String, Object> condition);

}
