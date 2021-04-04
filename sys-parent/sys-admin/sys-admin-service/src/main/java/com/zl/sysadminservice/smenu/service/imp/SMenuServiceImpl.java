package com.zl.sysadminservice.smenu.service.imp;

import com.zl.domain.SMenu;
import com.zl.sysadminservice.smenu.mapper.SMenuMapper;
import com.zl.sysadminservice.smenu.service.SMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class SMenuServiceImpl implements SMenuService {

    @Autowired
    private SMenuMapper sMenuMapper;

    @Override
    public List<SMenu> selectSMenu(String parentId){
        List<SMenu> sMenus = sMenuMapper.selectSMenu(parentId);
        sMenus.forEach(sMenu -> {
            String id = sMenu.getId();
            List<SMenu> sMenus1 = selectSMenu(id);
            sMenu.setChildren(sMenus1);
        });
        return sMenus;
    }
}
