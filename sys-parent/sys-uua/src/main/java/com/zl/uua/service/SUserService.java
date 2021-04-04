package com.zl.uua.service;


import com.zl.uua.domain.SUser;

/**
 * @author zhongliang
 */
public interface SUserService {

    /**
     * 根据用户名查询用户
     * @param sUser 用户
     * @return 用户
     */
    SUser selectForLogin(SUser sUser);

    /**
     * 新增用户
     * @param sUser 用户
     * @return 插入数据量
     */
    int addSUSer(SUser sUser);
}
