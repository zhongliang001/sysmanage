package com.zl.syssequence.service;

import org.springframework.stereotype.Service;

/**
 * @author zhongliang
 */
@Service
public interface SequenceService {

    /**
     * 获取sequence
     *
     * @param name 模板名
     * @return sequence
     */
    Long getSeqence(String name);

    /**
     * 重置序列
     *
     * @param name 序列名
     * @return 重置数量
     */
    Long resetSeq(String name);

    /**
     * 更新序列
     *
     * @param name 序列名
     * @return 更新数量
     */
    Integer updateSeq(String name);
}
