package com.zl.sysadminservice.smenu.service;

import com.zl.domain.SMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface SMenuService {

    /**
     * 根据父节点查询菜单
     * @param parentId 父节点id
     * @return 菜单集合
     */
    List<SMenu> selectSMenu(String parentId);
}
