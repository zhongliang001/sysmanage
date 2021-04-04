package com.zl.uua.mapper;

import com.zl.uua.domain.SysUser;

/**
 * @author zhongliang
 */
public interface SysUerMapper {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    SysUser selectForLogin(String username);

    /**
     * 新增用户
     * @param sUser 用户
     * @return 插入数据量
     */
    int addSysUSer(SysUser sUser);
}
