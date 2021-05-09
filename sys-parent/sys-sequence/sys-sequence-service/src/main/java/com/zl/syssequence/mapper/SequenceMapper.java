package com.zl.syssequence.mapper;

/**
 * @author zhongliang
 */
public interface SequenceMapper {

    /**
     * 获取序列
     * @param name 序列名
     * @return 序列
     */
    Long getSeq(String name);

    /**
     * 重置序列
     * @param name 序列名
     * @return 重置数量
     */
    Long resetSeq(String name);

    /**
     * 更新序列
     * @param name 序列名
     * @return 更新数量
     */
    Integer updateSeq(String name);
}
