package com.zl.sysadminservice.menu.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.domain.Menu;
import com.zl.dto.MenuRightDto;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.menu.mapper.MenuMapper;
import com.zl.sysadminservice.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class MenuServiceImpl implements MenuService {

    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private SequenceFeign sequenceFeign;

    @Override
    public List<Menu> selectMenu(String parentId) {
        return menuMapper.selectMenu(parentId);
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

    @Override
    public List<MenuRightDto> selectByRole(QueryCondition queryCondition) {
        logger.info("接受到菜单权限查询请求：{}", queryCondition);
        return menuMapper.selectByRole(queryCondition.getCondition());
    }
}
