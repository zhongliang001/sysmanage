package com.zl.sysadminservice.dict.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.Dict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    List<Dict> selectGroups(QueryCondition queryCondition);

    /**
     * 查询数据字典分组列表
     * @param condition 查询条件
     * @return 数据字典集合
     */
    List<Dict> selectGroup(Map<String, Object> condition);
    /**
     * 查询数据字典
     * @param queryCondition 查询条件
     * @return 数据字典集合
     */
    List<Dict> select(QueryCondition queryCondition);

    /**
     * 新增数据字典
     * @param dict 数据字典
     * @return 新增数量
     */
    int save(Dict dict);

    /**
     * 删除数据字典
     * @param id 数据字典id
     * @return 删除数量
     */
    int delDict(String id);

    /**
     * 根据数据字典类型删除是数据字典
     * @param dictType 数据字典类型
     * @return 删除数量
     */
    int delete(String dictType);

    /**
     * 修改字典描述
     * @param dict 字典
     * @return 修改数量
     */
    int update(Dict dict);

    /**
     * 修改字典描述
     * @param dict 字典
     * @return 修改数量
     */
    int updateDict(Dict dict);
}
