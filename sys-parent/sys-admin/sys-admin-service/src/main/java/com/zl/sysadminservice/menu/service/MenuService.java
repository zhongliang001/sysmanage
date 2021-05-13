package com.zl.sysadminservice.menu.service;

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
}
