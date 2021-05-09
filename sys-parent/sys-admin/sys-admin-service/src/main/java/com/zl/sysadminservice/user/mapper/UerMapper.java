package com.zl.sysadminservice.user.mapper;

import com.zl.domain.User;

/**
 * @author zhongliang
 */
public interface UerMapper {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    User selectForLogin(String username);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入数据量
     */
    int addUser(User user);
}
