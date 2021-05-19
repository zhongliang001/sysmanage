package com.zl.syssequence.format;

import com.zl.syssequence.service.SequenceService;

/**
 * @author zhongliang
 */
public interface FormatInterface {

    /**
     * 格式化seq片段
     * @param format 片段模板
     * @param sequenceService seq 服务
     * @return  seq片段
     */
    String format(String format, SequenceService sequenceService);
}
