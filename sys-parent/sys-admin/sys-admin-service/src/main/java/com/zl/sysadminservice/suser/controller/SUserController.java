package com.zl.sysadminservice.suser.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.MD5Util;
import com.zl.common.util.ResultUtil;
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
    public ResultDto<SUser> login(@RequestBody SUser sUser){
        sUser = sUserService.selectForLogin(sUser);
        return ResultUtil.genenrate(sUser, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/register")
    public ResultDto<Integer> register(@RequestBody SUser sUser){
        int i = 0;
        i = sUserService.addSUSer(sUser);
        return ResultUtil.genenrate(i, ErrDict.SUCCESS_ADD_CODE);
    }

}
