package com.zl.syssequence.template.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.sequence.domain.Template;
import com.zl.syssequence.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultDto<List<Template>> select(@RequestBody QueryCondition queryCondition) {
        List<Template> list = templateService.select(queryCondition);
        return ResultUtil.genenrate(list, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/add")
    public ResultDto<Integer> add(@RequestBody Template template) {
        int num = templateService.add(template);
        return ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }
    @PostMapping("/update")
    public ResultDto<Integer> update(@RequestBody Template template) {
        int num = templateService.update(template);
        return ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_UPDATE_CODE);
    }

    @PostMapping("/delete")
    public ResultDto<Integer> deleteByPrimaryKey(@RequestParam(value="id") String id) {
        return ResultUtil.genenrate(templateService.delete(id), TradeCodeDict.SUCCESS_DELETE_CODE);
    }
}
