package com.zl.sysadminservice.menu.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.Menu;
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
}
