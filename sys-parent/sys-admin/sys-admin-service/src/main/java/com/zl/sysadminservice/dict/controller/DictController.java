package com.zl.sysadminservice.dict.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Dict;
import com.zl.sysadminservice.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ResultUtil.genenrate(sdicts, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @GetMapping("/dictTree")
    public ResultDto<Map<String, Map<String, String>>> selectSdictTree(String sdictType) {
        Map<String, Map<String, String>> dictData = dictService.selectSdictTree(sdictType);
        return ResultUtil.genenrate(dictData, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/selectGroups")
    public ResultDto<List<Dict>> selectGroups(@RequestBody QueryCondition queryCondition){
        List<Dict> dicts = dictService.selectGroups(queryCondition);
        return ResultUtil.genenrate(dicts, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/selectGroup")
    public ResultDto<List<Dict>> selectGroup(@RequestBody Map<String, Object> condition){
        List<Dict> dicts = dictService.selectGroup(condition);
        return ResultUtil.genenrate(dicts, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/select")
    public ResultDto<List<Dict>> select(@RequestBody QueryCondition queryCondition){
        List<Dict> dicts = dictService.select(queryCondition);
        return ResultUtil.genenrate(dicts, TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody Dict dict){
        int num = dictService.save(dict);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/delDict")
    public ResultDto<Integer> delDict(@RequestParam(value="id")  String id){
        int num = dictService.delDict(id);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/delete")
    public ResultDto<Integer> delete(@RequestParam(value="dictType") String dictType){
        int num = dictService.delete(dictType);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/update")
    public ResultDto<Integer> update(@RequestBody Dict dict){
        int num = dictService.update(dict);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/updateDict")
    public ResultDto<Integer> updateDict(@RequestBody Dict dict){
        int num = dictService.updateDict(dict);
        return  ResultUtil.genenrate(num, TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/reloadRedisDict")
    public ResultDto<Map<String, Map<String, String>>>  reloadRedisDict(){
        dictService.clearRedisDict();
        Map<String, Map<String, String>> dictData = dictService.selectSdictTree(null);
        return  ResultUtil.genenrate(dictData,TradeCodeDict.SUCCESS_UPDATE_CODE);
    }
}
