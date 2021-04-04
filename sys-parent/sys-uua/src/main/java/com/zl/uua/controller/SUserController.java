package com.zl.uua.controller;

import com.zl.uua.domain.SUser;
import com.zl.uua.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongliang
 */

@RestController
@RequestMapping("/user")
public class SUserController {

    @Autowired
    private SUserService sUserService;

//    @PostMapping("/login")
//    public SUser login(@RequestBody SUser sUser){
//        sUser = sUserService.selectForLogin(sUser);
//        return sUser;
//    }

    @PostMapping("/register")
    public Integer register(@RequestBody SUser sUser){
        return sUserService.addSUSer(sUser);
    }

}
