package com.zl.sysadminservice.role.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Role;
import com.zl.sysadminservice.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 *  角色控制类
 * @author zhongliang
 */
@RestController
@RequestMapping("/role")
@EnableWebMvc
public class RoleController {

    /**
     * 角色的service 接口
     */
    @Autowired
    private RoleService roleService;

    /**
     * 根据条件查询角色
     * @param queryCondition 查询条件
     * @return  返回角色列表
     */
    @PostMapping("/select")
    public ResultDto<List<Role>> select(@RequestBody  QueryCondition queryCondition){
        return ResultUtil.genenrate(roleService.select(queryCondition),  TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    /**
     * 新增角色
     * @param role 角色
     * @return 新增角色条数
     */
    @PostMapping("/add")
    public ResultDto<Integer> add(@RequestBody Role role){
        return ResultUtil.genenrate(roleService.add(role),  TradeCodeDict.SUCCESS_ADD_CODE);
    }

    /**
     * 修改角色
     * @param role 角色
     * @return 修改角色条数
     */
    @PostMapping("/update")
    public ResultDto<Integer> update(@RequestBody Role role){
        return ResultUtil.genenrate(roleService.update(role),  TradeCodeDict.SUCCESS_UPDATE_CODE);
    }

    /**
     * 删除角色
     * @param id 角色id
     * @return 删除角色条数
     */
    @PostMapping("/delete")
    public ResultDto<Integer> delete(@RequestParam(value="id") String id){
        return ResultUtil.genenrate(roleService.delete(id),  TradeCodeDict.SUCCESS_DELETE_CODE);
    }
}
