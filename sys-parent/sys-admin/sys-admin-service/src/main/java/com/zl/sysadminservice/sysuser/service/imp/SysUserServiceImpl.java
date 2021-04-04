package com.zl.sysadminservice.sysuser.service.imp;

import com.zl.common.error.ErrDict;
import com.zl.common.exception.ZlException;
import com.zl.common.util.MD5Util;
import com.zl.domain.SysUser;
import com.zl.sysadminservice.sysuser.mapper.SysUerMapper;
import com.zl.sysadminservice.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author zhongliang
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUerMapper sysUerMapper;

    @Autowired
    private MD5Util MD5Util;

    @Override
    public SysUser selectForLogin(SysUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        SysUser sysUser = sysUerMapper.selectForLogin(username);
        if(sysUser == null){
            throw new ZlException(ErrDict.FAILED_LOGIN_FAILED);
        }
        String password1  =sysUser.getPassword();
        String enPassword = MD5Util.encryption(password);
        if(enPassword.equals(password1)){
            sysUser.setPassword("");
            return sysUser;
        }else{
            throw new ZlException(ErrDict.FAILED_LOGIN_FAILED);
        }
    }

    @Transactional(rollbackFor = ZlException.class)
    @Override
    public int addSysUSer(SysUser sysUser) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        sysUser.setId(id);
        sysUser.setPassword(MD5Util.encryption(sysUser.getPassword()));
        int i;
        try{
            i =sysUerMapper.addSysUSer(sysUser);

        }catch (Exception e){
            throw new ZlException(ErrDict.FAILED_ADD_CODE);
        }
        return i;
    }
}
