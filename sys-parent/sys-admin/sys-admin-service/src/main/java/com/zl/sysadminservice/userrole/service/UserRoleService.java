package com.zl.sysadminservice.userrole.service;

import com.zl.domain.UserRole;
import com.zl.dto.UserRoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface UserRoleService {

    /**
     * 根据id 删除用户角色
     *
     * @param id 角色id
     * @return 删除条数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入一条用户角色
     *
     * @param userRole 用户角色
     * @return 插入条数
     */
    int insert(UserRole userRole);

    /**
     * 根据用户角色id查用用户角色
     *
     * @param id 用户角色id
     * @return 用户角色
     */
    UserRole selectByPrimaryKey(String id);

    /**
     * 查用用户角色
     *
     * @return 所有用户角色
     */
    List<UserRole> selectAll();

    /**
     * 更新一条用户角色
     *
     * @param userRole 用户角色
     * @return 更新条数
     */
    int updateByPrimaryKey(UserRole userRole);


    /**
     * 用户角色配置
     *
     * @param userRoleDto 用户角色
     */
    void config(UserRoleDto userRoleDto);
}
