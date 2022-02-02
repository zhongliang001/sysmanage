package com.zl.syssequence.controller;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import com.zl.common.util.ResultUtil;
import com.zl.sequence.Template;
import com.zl.syssequence.format.FormatEnum;
import com.zl.syssequence.format.FormatInterface;
import com.zl.syssequence.service.SequenceService;
import com.zl.syssequence.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
        List<Template> templates = templateService.select(name);
        if (templates.isEmpty()) {
            throw new ZlException(TradeCodeDict.NO_TEMPLATE_CODE);
        }
        Template template = templates.get(0);
        String temp = template.getTemp();
        // aa${ss}${D(yyyy-mm-dd)}-${S{NNN[]}}
        return ResultUtil.genenrate(fomartSeqence(temp), TradeCodeDict.SUCCESS_QUERRY_CODE);
    }

    public String fomartSeqence(String temp){
        String seq = "";
        List<String> tps = new ArrayList<>();
        String[] split = temp.split("\\$\\{|}");
        for (String sp : split) {
            if (StringUtils.isEmpty(sp)) {
                continue;
            }
            String regex = "[()]";
            Pattern p = Pattern.compile(regex);
            boolean b = p.matcher(sp).find();
            if (!b) {
                seq += sp;
            }
            String[] split1 = sp.split(regex);
            Class<FormatInterface> format = get(split1[0]);
            if (format != null) {
                try {
                    FormatInterface formatInterface = format.newInstance();
                    int x = split1.length;
                    if (x > 1) {
                        seq += formatInterface.format(split1[1], sequenceService);
                    } else {
                        seq += formatInterface.format(null, sequenceService);
                    }

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return seq;
    }

    private Class<FormatInterface> get(String name){
        for(FormatEnum fe : FormatEnum.values()){
            if (fe.name().equals(name)) {
                return fe.getFormat();
            }
        }
        return null;
    }
}
