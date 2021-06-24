package com.zl.sysadminservice.dict.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Dict;
import com.zl.sysadminservice.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @GetMapping("/")
    public ResultDto<List<Dict>> selectSdict(Dict sdict) {
        List<Dict> sdicts = dictService.selectSdict(sdict);
        return ResultUtil.genenrate(sdicts, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @GetMapping("/dictTree")
    public ResultDto<Map<String, List<Dict>>> selectSdictTree(String sdictType) {
        List<String> sdictTypes = dictService.selctSdictByType(sdictType);
        Map<String, List<Dict>> dictData = new HashMap<>(16);
        for (String type : sdictTypes) {
            Dict sdict = new Dict();
            sdict.setDictType(type);
            List<Dict> sdicts = dictService.selectSdict(sdict);
            dictData.put(type, sdicts);
        }
        return ResultUtil.genenrate(dictData, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/selectGroup")
    public ResultDto<List<Dict>> selectGroup(@RequestBody QueryCondition queryCondition){
        List<Dict> dicts = dictService.selectGroup(queryCondition);
        return ResultUtil.genenrate(dicts, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/select")
    public ResultDto<List<Dict>> select(@RequestBody QueryCondition queryCondition){
        List<Dict> dicts = dictService.select(queryCondition);
        return ResultUtil.genenrate(dicts, ErrDict.SUCCESS_QUERRY_CODE);
    }
}
