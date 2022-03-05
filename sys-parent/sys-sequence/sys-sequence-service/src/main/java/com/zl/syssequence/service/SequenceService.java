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

    /**
     * 生成流水号
     * @param temp 模板
     * @return 流水号
     */
    String fomartSeqence(String temp);
}
