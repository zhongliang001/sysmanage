package com.zl.sysadminservice.user.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.MD5Util;
import com.zl.common.util.ResultUtil;
import com.zl.domain.User;
import com.zl.sysadminservice.user.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MD5Util MD5Util;

    @PostMapping("/login")
    public ResultDto<User> login(@RequestBody User user) {
        user = userService.selectForLogin(user);
        return ResultUtil.genenrate(user, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/query")
    public ResultDto<User> query(@RequestBody String username) {
        User user = new User();
        user.setUsername(username);
        user = userService.selectForLogin(user);
        return ResultUtil.genenrate(user, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/register")
    public ResultDto<Integer> register(@RequestBody User user) {
        int i = userService.addUser(user);
        return ResultUtil.genenrate(i, ErrDict.SUCCESS_ADD_CODE);
    }

}
