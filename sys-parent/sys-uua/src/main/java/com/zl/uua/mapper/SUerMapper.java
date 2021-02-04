package com.zl.uua.mapper;


import com.zl.uua.domain.SUser;

public interface SUerMapper {

    SUser selectForLogin(String username);

    int addSUSer(SUser sUser);
}
