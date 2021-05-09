package com.zl.sysadminservice.sysmenu.service.imp;

import com.zl.domain.SysMenu;
import com.zl.sysadminservice.sysmenu.mapper.SysMenuMapper;
import com.zl.sysadminservice.sysmenu.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> selectSysMenu(String parentId) {
        List<SysMenu> sysMenus = sysMenuMapper.selectSysMenu(parentId);
        sysMenus.forEach(sMenu -> {
            String id = sMenu.getId();
            List<SysMenu> sysMenus1 = selectSysMenu(id);
            sMenu.setChildren(sysMenus1);
        });
        return sysMenus;
    }
}
