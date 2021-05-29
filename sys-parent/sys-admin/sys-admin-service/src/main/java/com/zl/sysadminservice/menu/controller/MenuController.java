package com.zl.sysadminservice.menu.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Menu;
import com.zl.sysadminservice.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResultUtil.genenrate(menus, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/select")
    public ResultDto<List<Menu>> select(@RequestBody QueryCondition queryCondition) {
        List<Menu> menus = menuService.select(queryCondition);
        return ResultUtil.genenrate(menus, ErrDict.SUCCESS_QUERRY_CODE);
    }
}
