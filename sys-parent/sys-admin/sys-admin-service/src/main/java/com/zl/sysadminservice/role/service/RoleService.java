package com.zl.sysadminservice.role.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 角色的service接口
 * @author zhongliang
 */
@Service
public interface RoleService {

    /**
     * 根据条件查询角色
     * @param queryCondition 查询条件
     * @return 返回角色列表
     */
    List<Role> select(QueryCondition queryCondition);

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

    /**
     *  查询用户已有的角色，以及未拥有的角色
     * @param userId 用户id
     * @return {
     *     chooesedData:[{name:'',value:''}],
     *     unchooesedData:[{name:'',value:''}]
     * }
     */
    Map<String, List<Map<String,String>>> queryRoleForChoose(String userId);
}
