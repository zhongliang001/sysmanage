package com.zl.sysadminservice.suser.controller;

import com.zl.common.util.MD5Util;
import com.zl.domain.SUser;
import com.zl.sysadminservice.suser.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suser")
public class SUserController {

    @Autowired
    private SUserService sUserService;

    @Autowired
    private MD5Util MD5Util;

    @PostMapping("/login")
    public SUser login(@RequestBody SUser sUser){
        return sUserService.selectForLogin(sUser);
    }

    @PostMapping("/register")
    public int register(@RequestBody SUser sUser){
        return sUserService.addSUSer(sUser);
    }

}
