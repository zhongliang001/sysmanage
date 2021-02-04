package com.zl.uua;

import com.zl.uua.domain.SUser;
import com.zl.uua.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityService implements UserDetailsService{

    @Autowired
    private SUserService sUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SUser sUser = new SUser();
        sUser.setUsername(s);
        return sUserService.selectForLogin(sUser);
    }
}
