package com.zl.sysadminservice.user.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.User;
import com.zl.dto.UserDto;

import java.util.List;

/**
 * @author zhongliang
 */

public interface UserService {

    /**
     * 根据用户名查询用户
     *
     * @param user 用户
     * @return 用户
     */
    UserDto selectForLogin(User user);

    /**
     * 注册用户
     *
     * @param user 用户
     * @return 插入数据量
     */
    int register(User user);

    /**
     * 查询用户列表
     * @param queryCondition 查询条件
     * @return 查询用户列表
     */
    List<User> select(QueryCondition queryCondition);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入数据量
     */
    int add(User user);

    /**
     * 修改用户
     * @param user 用户信息
     * @return 修改数量
     */
    int update(User user);

    /**
     * 刪除用戶
     * @param id 用戶id
     * @return 返回删除条数
     */
    int delete(String id);

}
