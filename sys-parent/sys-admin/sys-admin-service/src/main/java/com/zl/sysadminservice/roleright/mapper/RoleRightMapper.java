package com.zl.sysadminservice.roleright.mapper;

import com.zl.domain.RoleRight;
import java.util.List;

public interface RoleRightMapper {

    /**
     *  根据角色权限id 删除角色权限
     * @param id 角色权限id
     * @return 删除条数
     */
    int deleteByPrimaryKey(String id);

    /**
     *  插入角色权限
     * @param roleRight 角色权限
     * @return 新增条数
     */
    int insert(RoleRight roleRight);

    /**
     *  查询角色权限
     * @param id 角色权限id
     * @return 角色权限
     */
    RoleRight selectByPrimaryKey(String id);

    /**
     *  查询所有角色权限
     * @return 角色权限
     */
    List<RoleRight> selectAll();

    /**
     *  更新角色权限
     * @param roleRight 角色权限
     * @return 更新条数
     */
    int updateByPrimaryKey(RoleRight roleRight);

    /**
     * 根据角色id 删除角色权限
     * @param roleId 角色id
     * @return 返回删除条数
     */
    int deleteByRoleId(String roleId);

    /**
     * 批量新增
     * @param roleRights 新增的数据
     * @return 返回新增记录数
     */
    int inserBatch(List<RoleRight> roleRights);
}