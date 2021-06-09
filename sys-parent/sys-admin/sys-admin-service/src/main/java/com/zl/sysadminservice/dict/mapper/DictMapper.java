package com.zl.sysadminservice.dict.mapper;

import com.zl.domain.Dict;

import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
public interface DictMapper {
    /**
     * 查询数据字典
     *
     * @param sdict 数据字典
     * @return 数据字典集合
     */
    List<Dict> selectSdict(Dict sdict);

    /**
     * 根据字典类型查询数据字典
     *
     * @param sdictType 数据字典类型
     * @return 数据字典集合
     */
    List<String> selctSdictByType(String sdictType);

    /**
     * 查询数据字典分组列表
     * @param condition 查询条件
     * @return 数据字典集合
     */
    List<Dict> selectGroup(Map<String, Object> condition);
}
