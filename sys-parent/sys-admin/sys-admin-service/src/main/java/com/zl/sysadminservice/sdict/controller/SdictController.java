package com.zl.sysadminservice.sdict.controller;

import com.zl.domain.Sdict;
import com.zl.sysadminservice.sdict.service.SdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sdict")
public class SdictController {

    @Autowired
    private SdictService sdictService;

    @GetMapping("/")
    public List<Sdict> selectSdict(Sdict sdict) {
        return sdictService.selectSdict(sdict);
    }

    @GetMapping("/sdictTree")
    public Map<String, Map<String,String>> selectSdictTree(String sdictType){
        List<String> sdictTypes = sdictService.selctSdictByType(sdictType);
        Map<String, Map<String,String>> result = new HashMap<>();
        for(String type : sdictTypes){
            Sdict sdict = new Sdict();
            sdict.setDictType(type);
            List<Sdict> sdicts = sdictService.selectSdict(sdict);
            Map<String, String> map = new HashMap<>();
            sdicts.forEach(sdict1 -> {
                map.put(sdict1.getEnName(),sdict1.getCnName());
            });
            result.put(type, map);
        }
        return result;
    }
}
