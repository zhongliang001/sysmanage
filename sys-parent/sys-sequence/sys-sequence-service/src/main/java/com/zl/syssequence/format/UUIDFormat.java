package com.zl.syssequence.format;

import com.zl.syssequence.service.SequenceService;

import java.util.UUID;

/**
 * @author zhongliang
 */
public class UUIDFormat implements FormatInterface {
    @Override
    public String format(String format, SequenceService sequenceService) {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
