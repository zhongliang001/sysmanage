package com.zl.sysadminservice.user.service;

import com.zl.domain.User;

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
    User selectForLogin(User user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入数据量
     */
    int addUser(User user);
}
