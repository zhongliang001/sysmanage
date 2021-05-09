package com.zl.syssequence.format;

import com.zl.common.util.DateUtil;
import com.zl.syssequence.service.SequenceService;

import java.util.Date;
/**
 * @author zhongliang
 */
public class DateFormat implements FormatInterface {
    /**
     * 格式化seq片段
     * @param format 片段模板
     * @return  seq片段
     */
    @Override
    public String format(String format, SequenceService sequenceService) {
        return DateUtil.format(new Date(), format);
    }
}
