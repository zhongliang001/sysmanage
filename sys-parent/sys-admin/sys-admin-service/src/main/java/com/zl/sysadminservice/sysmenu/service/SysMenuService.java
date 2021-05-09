package com.zl.sysadminservice.sysmenu.service;

import com.zl.domain.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface SysMenuService {

    /**
     * 根据父节点查询菜单
     *
     * @param parentId 父节点id
     * @return 菜单集合
     */
    List<SysMenu> selectSysMenu(String parentId);
}
