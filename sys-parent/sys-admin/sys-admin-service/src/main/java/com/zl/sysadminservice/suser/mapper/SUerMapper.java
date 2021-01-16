package com.zl.sysadminservice.suser.mapper;

import com.zl.domain.SUser;

public interface SUerMapper {

    SUser selectForLogin(String username);

    int addSUSer(SUser sUser);
}
