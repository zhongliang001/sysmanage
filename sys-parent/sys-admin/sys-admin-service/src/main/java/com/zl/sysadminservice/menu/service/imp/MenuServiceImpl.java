package com.zl.sysadminservice.menu.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.base.service.RedisService;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.exception.ZlException;
import com.zl.common.util.HttpRequestUtil;
import com.zl.domain.Menu;
import com.zl.domain.Role;
import com.zl.dto.MenuDto;
import com.zl.dto.MenuRightDto;
import com.zl.dto.UserDto;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.menu.mapper.MenuMapper;
import com.zl.sysadminservice.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private RedisService redisService;

    @Override
    public List<MenuDto> selectMenu(String parentId) {
        logger.info("开始请求查询菜单列表...");
        UserDto userDto = HttpRequestUtil.getRequestUser();
        if (userDto == null) {
            throw new ZlException("你暂时无法访问，请重新登录！");
        }
        logger.debug("token 中的用户信息为:{}", userDto);
        // 获取用户角色，根据用户角色查询用户的菜单及权限
        List<Role> roles = userDto.getRoles();
        String actions = roles.stream().map(Role::getId).collect(Collectors.joining(","));
        Map<String, Object> map = new HashMap<>(16);
        map.put("actions", actions);

        List<MenuDto> menuDtos = menuMapper.selectMenu(map);
        // 将查询回来的菜单权限保存至redis中用来后面做操作权限校验
        Map<String, List<MenuDto>> rightMap = new HashMap<>(16);
        rightMap.put(userDto.getId(), menuDtos);
        redisService.putAll("right", rightMap);
        logger.info("请求查询菜单列表结束...");
        return menuDtos;
    }

    @Override
    public List<Menu> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return menuMapper.select(queryCondition.getCondition());
    }

    @Override
    public int save(Menu menu){
        ResultDto<String> menu1 = sequenceFeign.getSequnces("MENU_TMP");
        menu.setMenuId(menu1.getData());
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
