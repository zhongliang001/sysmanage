package com.zl.syssequence.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import com.zl.common.util.ResultUtil;
import com.zl.syssequence.service.SequenceService;
import com.zl.syssequence.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhongliang
 */
@RestController
@RequestMapping("/sequence")
public class SequenceController {

    @Autowired
    @Resource(name="${sequenceService}")
    private SequenceService sequenceService;

    @Autowired
    private TemplateService templateService;

    @PostMapping("/getsequnces")
    public ResultDto<String> getSequnces(@RequestBody String name){
        String temp = templateService.getTemplate(name);
        // aa${ss}${D(yyyy-mm-dd)}-${S{NNN[]}}
        return ResultUtil.genenrate(sequenceService.fomartSeqence(temp), TradeCodeDict.SUCCESS_QUERRY_CODE);
    }
}
