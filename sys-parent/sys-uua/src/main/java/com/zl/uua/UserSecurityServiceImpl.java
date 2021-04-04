package com.zl.uua;

import com.zl.uua.domain.SysUser;
import com.zl.uua.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author zhongliang
 */
@Component
public class UserSecurityServiceImpl implements UserDetailsService{

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        return sysUserService.selectForLogin(sysUser);
    }
}
