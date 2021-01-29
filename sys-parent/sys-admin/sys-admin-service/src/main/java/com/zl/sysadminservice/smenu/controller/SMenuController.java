package com.zl.sysadminservice.smenu.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.SMenu;
import com.zl.sysadminservice.smenu.service.SMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/smenu")
public class SMenuController {

    @Autowired
    private SMenuService sMenuService;

    @PostMapping("/selectMenu")
    public ResultDto<List> selectMenu(){
        List<SMenu> sMenus = sMenuService.selectSMenu(null);
        return ResultUtil.genenrate(sMenus, ErrDict.SUCCESS_QUERRY_CODE);
    }
}
