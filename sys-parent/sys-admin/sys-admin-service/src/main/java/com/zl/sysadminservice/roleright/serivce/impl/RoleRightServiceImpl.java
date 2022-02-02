package com.zl.sysadminservice.roleright.serivce.impl;

import com.zl.common.exception.ZlException;
import com.zl.domain.RoleRight;
import com.zl.dto.ActionDto;
import com.zl.dto.MenuRightDto;
import com.zl.dto.RoleMenuRightDto;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.roleright.mapper.RoleRightMapper;
import com.zl.sysadminservice.roleright.serivce.RoleRightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class RoleRightServiceImpl implements RoleRightService {

    private Logger logger = LoggerFactory.getLogger(RoleRightServiceImpl.class);

    @Autowired
    private SequenceFeign sequenceFeign;

    @Autowired
    private RoleRightMapper roleRightMapper;

    private static final String ROLE_RIGHT_TMP = "ROLE_RIGHT_TMP";

    @Override
    @Transactional(rollbackFor = ZlException.class)
    public int add(RoleMenuRightDto roleMenuRightDto) {
        List<RoleRight> list= new ArrayList<>();
        try{
            logger.info("接收到新增角色权限请求： {}", roleMenuRightDto);
            // 删除该角色的全部权限
            String roleId = roleMenuRightDto.getRoleId();
            roleRightMapper.deleteByRoleId(roleId);
            // 遍历现有的菜单权限， 生成roleRight
            List<MenuRightDto> menuRightDtos = roleMenuRightDto.getMenuRightDtos();
            if (menuRightDtos != null) {
                menuRightDtos.stream().forEach(menuRightDto -> {
                    List<ActionDto> actionDtos = menuRightDto.getActionDtos();
                    if(actionDtos != null){
                        actionDtos.stream().forEach(actionDto->{
                            Boolean hasRight = actionDto.getHasRight();
                            if (hasRight) {
                                RoleRight roleRight = new RoleRight();
                                String id = sequenceFeign.getSequnces(ROLE_RIGHT_TMP).getData();
                                roleRight.setId(id);
                                roleRight.setRoleId(roleId);
                                roleRight.setActionId(actionDto.getId());
                                list.add(roleRight);
                            }

                        });
                    }
                });
            }
            if(list.size() > 0){
                return roleRightMapper.inserBatch(list);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ZlException("新增失败");
        }

        return 0;
    }
}
