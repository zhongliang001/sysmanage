package com.zl.syssequence.service.impl;

import com.zl.syssequence.mapper.SequenceMapper;
import com.zl.syssequence.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhongliang
 */
@Service("SequenceServiceImpl")
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    public Long getSeqence(String name) {
        return sequenceMapper.getSeq(name);
    }

    @Override
    public Long resetSeq(String name) {
        return sequenceMapper.resetSeq(name);
    }

    /**
     * 更新序列
     * @param name 序列名
     * @return 更新数量
     */
    @Override
    public Integer updateSeq(String name){
        return sequenceMapper.updateSeq(name);
    }
}
