package com.zl.sysadminservice.roleright.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.dto.RoleMenuRightDto;
import com.zl.sysadminservice.roleright.serivce.RoleRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/roleright")
public class RoleRightController {

    @Autowired
    private RoleRightService roleRightService;

    @PostMapping("/addRoleRight")
    public ResultDto<Integer> addRoleRight(@RequestBody RoleMenuRightDto roleMenuRightDto){
        return ResultUtil.genenrate(roleRightService.add(roleMenuRightDto), TradeCodeDict.SUCCESS_ADD_CODE);
    }

}
