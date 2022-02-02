package com.zl.sysadminservice.roleright.serivce;

import com.zl.dto.RoleMenuRightDto;
import org.springframework.stereotype.Service;

/**
 * @author zhongliang
 */
@Service
public interface RoleRightService {

    /**
     * 新增角色权限
     * @param roleMenuRightDto 菜单权限
     * @return 新增记录数
     */
    int add(RoleMenuRightDto roleMenuRightDto);
}
