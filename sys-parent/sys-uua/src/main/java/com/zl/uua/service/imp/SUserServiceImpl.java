package com.zl.uua.service.imp;

import com.zl.uua.domain.SUser;
import com.zl.uua.mapper.SUerMapper;
import com.zl.uua.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zhongliang
 */

@Service
public class SUserServiceImpl implements SUserService {

    @Autowired
    private SUerMapper sUerMapper;

    @Override
    public SUser selectForLogin(SUser loginUser) {
        return sUerMapper.selectForLogin(loginUser.getUsername());
    }

    @Override
    public int addSUSer(SUser sUser) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        sUser.setId(id);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        sUser.setPassword(bCryptPasswordEncoder.encode(sUser.getPassword()));
        return sUerMapper.addSUSer(sUser);
    }
}
