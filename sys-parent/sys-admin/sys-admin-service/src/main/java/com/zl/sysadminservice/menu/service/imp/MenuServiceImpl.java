package com.zl.sysadminservice.menu.service.imp;

import com.zl.domain.Menu;
import com.zl.sysadminservice.menu.mapper.MenuMapper;
import com.zl.sysadminservice.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenu(String parentId) {
        List<Menu> menus = menuMapper.selectMenu(parentId);
        menus.forEach(sMenu -> {
            String id = sMenu.getId();
            List<Menu> menus1 = selectMenu(id);
            sMenu.setChildren(menus1);
        });
        return menus;
    }
}
