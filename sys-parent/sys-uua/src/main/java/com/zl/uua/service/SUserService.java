package com.zl.uua.service;


import com.zl.uua.domain.SUser;

public interface SUserService {

    SUser selectForLogin(SUser sUser);

    int addSUSer(SUser sUser);
}
