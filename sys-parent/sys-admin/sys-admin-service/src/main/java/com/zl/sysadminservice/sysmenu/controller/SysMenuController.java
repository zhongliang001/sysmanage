package com.zl.sysadminservice.sysmenu.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.SysMenu;
import com.zl.sysadminservice.sysmenu.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/selectSysMenu")
    public ResultDto<List<SysMenu>> selectSysMenu() {
        List<SysMenu> sysMenus = sysMenuService.selectSysMenu(null);
        return ResultUtil.genenrate(sysMenus, ErrDict.SUCCESS_QUERRY_CODE);
    }
}
