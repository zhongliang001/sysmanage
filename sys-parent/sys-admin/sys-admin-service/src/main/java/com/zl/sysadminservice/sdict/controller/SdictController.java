package com.zl.sysadminservice.sdict.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrDict;
import com.zl.common.util.ResultUtil;
import com.zl.domain.Sdict;
import com.zl.sysadminservice.sdict.service.SdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */

@RestController
@RequestMapping("/sdict")
public class SdictController {

    @Autowired
    private SdictService sdictService;

    @GetMapping("/")
    public ResultDto<List<Sdict>> selectSdict(Sdict sdict) {
        List<Sdict> sdicts = sdictService.selectSdict(sdict);
        return ResultUtil.genenrate(sdicts, ErrDict.SUCCESS_QUERRY_CODE);
    }

    @GetMapping("/sdictTree")
    public ResultDto<Map<String, List<Sdict>>> selectSdictTree(String sdictType){
        List<String> sdictTypes = sdictService.selctSdictByType(sdictType);
        Map<String, List<Sdict>> dictData = new HashMap<>(16);
        for(String type : sdictTypes){
            Sdict sdict = new Sdict();
            sdict.setDictType(type);
            List<Sdict> sdicts = sdictService.selectSdict(sdict);
            dictData.put(type, sdicts);
        }
        return ResultUtil.genenrate(dictData, ErrDict.SUCCESS_QUERRY_CODE);
    }
}
