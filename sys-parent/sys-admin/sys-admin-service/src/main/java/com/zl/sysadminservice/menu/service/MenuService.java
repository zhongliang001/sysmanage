package com.zl.sysadminservice.menu.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.Menu;
import com.zl.dto.MenuRightDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface MenuService {

    /**
     * 根据父节点查询菜单
     *
     * @param parentId 父节点id
     * @return 菜单集合
     */
    List<Menu> selectMenu(String parentId);

    /**
     * 菜单查查询
     * @param queryCondition 查询条件
     * @return 菜单集合
     */
    List<Menu> select(QueryCondition queryCondition);

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
     * @param queryCondition 查询条件呢
     * @return 菜单权限
     */
    List<MenuRightDto> selectByRole(QueryCondition queryCondition);

}
