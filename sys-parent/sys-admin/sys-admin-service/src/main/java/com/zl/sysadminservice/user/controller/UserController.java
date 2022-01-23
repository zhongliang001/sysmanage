package com.zl.sysadminservice.user.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.MD5Util;
import com.zl.common.util.ResultUtil;
import com.zl.domain.User;
import com.zl.dto.UserDto;
import com.zl.sysadminservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResultDto<User> login(@RequestBody @Validated User user) {
        user = userService.selectForLogin(user);
        return ResultUtil.genenrate(user, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/query")
    public ResultDto<UserDto> query(@RequestBody String username) {
        User user = new User();
        user.setUsername(username);
        return ResultUtil.genenrate(userService.selectForLogin(user), TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/register")
    public ResultDto<Integer> register(@RequestBody User user) {
        int i = userService.register(user);
        return ResultUtil.genenrate(i, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/select")
    public ResultDto<List<User>> select(@RequestBody QueryCondition queryCondition) {
        return ResultUtil.genenrate(userService.select(queryCondition), TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/add")
    public ResultDto<Integer> add(@RequestBody User user) {
        int i = userService.add(user);
        return ResultUtil.genenrate(i, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/update")
    public ResultDto<Integer> update(@RequestBody User user) {
        int i = userService.update(user);
        return ResultUtil.genenrate(i, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/delete")
    public ResultDto<Integer> delete(@Param("id") String id){
        return ResultUtil.genenrate(userService.delete(id), TradeCodeDict.SUCCESS_DELETE_CODE);
    }
}
