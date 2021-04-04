package com.zl.uua.service.imp;

import com.zl.uua.domain.SysUser;
import com.zl.uua.mapper.SysUerMapper;
import com.zl.uua.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zhongliang
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUerMapper sysUerMapper;

    @Override
    public SysUser selectForLogin(SysUser loginUser) {
        return sysUerMapper.selectForLogin(loginUser.getUsername());
    }

    @Override
    public int addSysUSer(SysUser sysUser) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        sysUser.setId(id);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        return sysUerMapper.addSysUSer(sysUser);
    }
}
