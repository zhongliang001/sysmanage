package com.zl.sysadminservice.menu.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Menu;
import com.zl.sysadminservice.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/selectMenu")
    public ResultDto<List<Menu>> selectMenu() {
        List<Menu> menus = menuService.selectMenu(null);
        return ResultUtil.genenrate(menus, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/select")
    public ResultDto<List<Menu>> select(@RequestBody QueryCondition queryCondition) {
        List<Menu> menus = menuService.select(queryCondition);
        return ResultUtil.genenrate(menus, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody Menu menu){
        int num = menuService.save(menu);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/update")
    public ResultDto<Integer> update(@RequestBody Menu menu){
        int num = menuService.update(menu);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/delete")
    public ResultDto<Integer> delete(@RequestParam(value="id") String id){
        int num = menuService.delete(id);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }
}
