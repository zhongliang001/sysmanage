package com.zl.sysadminservice.menu.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.domain.Menu;
import com.zl.sys.sequence.feign.client.SequenceFeign;
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

    @Autowired
    private SequenceFeign sequenceFeign;

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

    @Override
    public List<Menu> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return menuMapper.select(queryCondition.getCondition());
    }

    @Override
    public int save(Menu menu){
        ResultDto<String> menu1 = sequenceFeign.getSequnces("MENU_TMP");
        menu.setId(menu1.getData());
        return menuMapper.save(menu);
    }

    @Override
    public int update(Menu menu){
        return menuMapper.update(menu);
    }

    @Override
    public int delete(String id){
        return menuMapper.delete(id);
    }

}
