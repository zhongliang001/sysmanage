package com.zl.syssequence.template.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.ResultUtil;
import com.zl.sequence.Template;
import com.zl.syssequence.template.service.TemplateService;
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
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping("/select")
    public ResultDto<List<Template>> select(String name) {
        List<Template> list = templateService.select(name);
        return ResultUtil.genenrate(list, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/add")
    public ResultDto<Integer> add(@RequestBody Template template) {
        int num = templateService.add(template);
        return ResultUtil.genenrate(num, ErrDict.SUCCESS_ADD_CODE);
    }
}
