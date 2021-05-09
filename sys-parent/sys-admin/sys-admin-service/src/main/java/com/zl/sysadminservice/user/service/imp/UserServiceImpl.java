package com.zl.sysadminservice.user.service.imp;

import com.zl.common.error.ErrDict;
import com.zl.common.exception.ZlException;
import com.zl.common.util.MD5Util;
import com.zl.domain.User;
import com.zl.sysadminservice.user.mapper.UerMapper;
import com.zl.sysadminservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author zhongliang
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UerMapper uerMapper;

    @Autowired
    private MD5Util MD5Util;

    @Override
    public User selectForLogin(User loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        User user = uerMapper.selectForLogin(username);
//        if (user == null) {
//            throw new ZlException(ErrDict.FAILED_LOGIN_FAILED);
//        }
//        String password1 = user.getPassword();
//        String enPassword = MD5Util.encryption(password);
//        if (enPassword.equals(password1)) {
//            user.setPassword("");
        return user;
//        } else {
//            throw new ZlException(ErrDict.FAILED_LOGIN_FAILED);
//        }
    }

    @Transactional(rollbackFor = ZlException.class)
    @Override
    public int addUser(User user) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(id);
        user.setPassword(MD5Util.encryption(user.getPassword()));
        int i;
        try {
            i = uerMapper.addUser(user);

        } catch (Exception e) {
            throw new ZlException(ErrDict.FAILED_ADD_CODE);
        }
        return i;
    }
}
