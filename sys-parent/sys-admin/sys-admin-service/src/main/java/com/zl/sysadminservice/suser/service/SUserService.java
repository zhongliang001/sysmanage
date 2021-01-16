package com.zl.sysadminservice.suser.service;

import com.zl.domain.SUser;


public interface SUserService {

    SUser selectForLogin(SUser sUser);

    int addSUSer(SUser sUser);
}
