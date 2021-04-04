package com.zl.sysadminservice.suser.mapper;

import com.zl.domain.SUser;

/**
 * @author zhongliang
 */
public interface SUerMapper {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    SUser selectForLogin(String username);

    /**
     * 新增用户
     * @param sUser 用户
     * @return 插入数据量
     */
    int addSUSer(SUser sUser);
}
