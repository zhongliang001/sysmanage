package com.zl.sysadminservice.role.mapper;

import com.zl.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * 角色表对应的Mapper
 * @author zhongliang
 */
public interface RoleMapper {

    /**
     * 根据条件查询角色
     * @param condition 查询条件
     * @return  返回角色列表
     */
    List<Role> select(Map<String, Object> condition);

    /**
     * 新增角色
     * @param role 角色
     * @return 新增角色条数
     */
    int add(Role role);

    /**
     * 修改角色
     * @param role 角色
     * @return 修改条数
     */
    int update(Role role);

    /**
     * 删除角色
     * @param id 角色id
     * @return 删除条数
     */
    int delete(String id);
}
