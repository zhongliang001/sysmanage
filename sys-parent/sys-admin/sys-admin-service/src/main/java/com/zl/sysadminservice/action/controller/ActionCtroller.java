package com.zl.sysadminservice.action.controller;

import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Action;
import com.zl.sysadminservice.action.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/action")
public class ActionCtroller {
    
    @Autowired
    private ActionService actionService;
    @PostMapping("/delete")
     public ResultDto<Integer> deleteByPrimaryKey(@RequestParam(value="id") String id) {
        return ResultUtil.genenrate(actionService.deleteByPrimaryKey(id), TradeCodeDict.SUCCESS_DELETE_CODE);
    }

    @PostMapping("/add")
    public ResultDto<Integer> insert(@RequestBody Action action) {
        return ResultUtil.genenrate(actionService.insert(action),  TradeCodeDict.SUCCESS_ADD_CODE);
    }

    @PostMapping("/selectByPrimaryKey")
    public ResultDto<Action> selectByPrimaryKey(@RequestParam(value="id") String id) {
        return ResultUtil.genenrate(actionService.selectByPrimaryKey(id),  TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/selectAll")
    public ResultDto<List<Action>> selectAll() {
        return ResultUtil.genenrate(actionService.selectAll(),  TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    @PostMapping("/update")
    public ResultDto<Integer> updateByPrimaryKey(@RequestBody Action action) {
        return ResultUtil.genenrate(actionService.updateByPrimaryKey(action),  TradeCodeDict.SUCCESS_UPDATE_CODE);
    }

    @PostMapping("/select")
    public ResultDto<List<Action>> select(@RequestBody QueryCondition queryCondition) {
        return ResultUtil.genenrate(actionService.select(queryCondition),  TradeCodeDict.SUCCESS_QUERRY_CODE);
    }
}
