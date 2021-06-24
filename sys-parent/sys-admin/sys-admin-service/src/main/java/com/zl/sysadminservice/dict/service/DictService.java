package com.zl.sysadminservice.dict.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface DictService {

    /**
     * 查询数据字典
     *
     * @param sdict 字典对象
     * @return 字典集合
     */
    List<Dict> selectSdict(Dict sdict);

    /**
     * 根据字典类型查询数据字典
     *
     * @param sdictType 字典类型
     * @return 字典集合
     */
    List<String> selctSdictByType(String sdictType);

    /**
     * 查询数据字典分组列表
     * @param queryCondition 查询条件
     * @return 数据字典集合
     */
    List<Dict> selectGroup(QueryCondition queryCondition);

    /**
     * 查询数据字典
     * @param queryCondition 查询条件
     * @return 数据字典集合
     */
    List<Dict> select(QueryCondition queryCondition);
}
