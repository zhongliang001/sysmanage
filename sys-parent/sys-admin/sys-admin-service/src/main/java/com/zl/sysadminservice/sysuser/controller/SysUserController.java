package com.zl.sysadminservice.sysuser.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.MD5Util;
import com.zl.common.util.ResultUtil;
import com.zl.domain.SysUser;
import com.zl.sysadminservice.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/suser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MD5Util MD5Util;

    @PostMapping("/login")
    public ResultDto<SysUser> login(@RequestBody SysUser sysUser){
        sysUser = sysUserService.selectForLogin(sysUser);
        return ResultUtil.genenrate(sysUser, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/register")
    public ResultDto<Integer> register(@RequestBody SysUser sUser){
        int i = sysUserService.addSysUSer(sUser);
        return ResultUtil.genenrate(i, ErrDict.SUCCESS_ADD_CODE);
    }

}
