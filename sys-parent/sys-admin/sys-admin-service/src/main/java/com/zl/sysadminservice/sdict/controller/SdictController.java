package com.zl.sysadminservice.sdict.controller;

import com.zl.domain.Sdict;
import com.zl.sysadminservice.sdict.service.SdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sdict")
public class SdictController {

    @Autowired
    private SdictService sdictService;

    @GetMapping("/")
    public List<Sdict> selectSdict(Sdict sdict) {
        return sdictService.selectSdict(sdict);
    }

}
