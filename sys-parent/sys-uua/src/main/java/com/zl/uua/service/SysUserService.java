package com.zl.uua.service;


import com.zl.uua.domain.SysUser;

/**
 * @author zhongliang
 */
public interface SysUserService {

    /**
     * 根据用户名查询用户
     * @param sysUser 用户
     * @return 用户
     */
    SysUser selectForLogin(SysUser sysUser);

    /**
     * 新增用户
     * @param sysUser 用户
     * @return 插入数据量
     */
    int addSysUSer(SysUser sysUser);
}
