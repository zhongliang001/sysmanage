package com.zl.sysadminservice.userrole.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.UserRole;
import com.zl.dto.UserRoleDto;
import com.zl.sysadminservice.userrole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/delete")
    public ResultDto<Integer> deleteByPrimaryKey(@Param("id") String id) {
        int i = userRoleService.deleteByPrimaryKey(id);
        return ResultUtil.genenrate(i, TradeCodeDict.SUCCESS_DELETE_CODE);
    }

    @PostMapping("/insert")
    public ResultDto<Integer> insert(@RequestBody UserRole userRole) {
        int i = userRoleService.insert(userRole);
        return ResultUtil.genenrate(i, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/selectByPrimaryKey")
    public ResultDto<UserRole> selectByPrimaryKey(@Param("id") String id) {
        UserRole userRole = userRoleService.selectByPrimaryKey(id);
        return ResultUtil.genenrate(userRole, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/selectAll")
    public ResultDto<List<UserRole>> selectAll() {
        List<UserRole> userRoles = userRoleService.selectAll();
        return ResultUtil.genenrate(userRoles, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/updateByPrimaryKey")
    public ResultDto<Integer> updateByPrimaryKey(@RequestBody UserRole userRole) {
        int i = userRoleService.updateByPrimaryKey(userRole);
        return ResultUtil.genenrate(i, TradeCodeDict.SUCCESS_UPDATE_CODE);
    }

    @PostMapping("/config")
    public ResultDto<Integer> config(@RequestBody UserRoleDto userRoleDto) {
        userRoleService.config(userRoleDto);
        return ResultUtil.genenrate(1, TradeCodeDict.SUCCESS_ADD_CODE);
    }
}
