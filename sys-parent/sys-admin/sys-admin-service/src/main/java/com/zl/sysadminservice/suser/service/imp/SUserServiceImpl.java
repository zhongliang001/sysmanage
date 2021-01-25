package com.zl.sysadminservice.suser.service.imp;

import com.zl.common.Exception.ZlException;
import com.zl.common.error.ErrDict;
import com.zl.common.util.MD5Util;
import com.zl.domain.SUser;
import com.zl.sysadminservice.suser.mapper.SUerMapper;
import com.zl.sysadminservice.suser.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class SUserServiceImpl implements SUserService {

    @Autowired
    private SUerMapper sUerMapper;

    @Autowired
    private MD5Util MD5Util;

    @Override
    public SUser selectForLogin(SUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        SUser sUser = sUerMapper.selectForLogin(username);
        if(sUser == null){
            throw new ZlException(ErrDict.FAILED_LOGIN_FAILED);
        }
        String password1  =sUser.getPassword();
        String enPassword = MD5Util.encryption(password);
        if(enPassword.equals(password1)){
            sUser.setPassword("");
            return sUser;
        }

        return null;
    }

    @Transactional
    @Override
    public int addSUSer(SUser sUser) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        sUser.setId(id);
        sUser.setPassword(MD5Util.encryption(sUser.getPassword()));
        int i = 0;
        try{
            i =sUerMapper.addSUSer(sUser);

        }catch (Exception e){
            throw new ZlException(ErrDict.FAILED_ADD_CODE);
        }
        return i;
    }
}
