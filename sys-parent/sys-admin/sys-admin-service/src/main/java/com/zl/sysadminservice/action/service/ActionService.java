package com.zl.sysadminservice.action.service;

import com.zl.common.domain.QueryCondition;
import com.zl.domain.Action;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface ActionService {

    /**
     * 根据主键删除
     * @param id 操作id
     * @return 删除条数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增操作
     * @param action 操作
     * @return 新增条数
     */
    int insert(Action action);

    /**
     * 根据主键查询
     * @param id 操作id
     * @return 查询到的操作
     */
    Action selectByPrimaryKey(String id);

    /**
     * 查询全部数据
     * @return 数据列表
     */
    List<Action> selectAll();

    /**
     * 更新操作
     * @param action 插入操作
     * @return 插入记录数
     */
    int updateByPrimaryKey(Action action);

    /**
     * 根据查询条件查询操作
     * @param queryCondition 查询条件
     * @return 查询记录
     */
    List<Action> select(QueryCondition queryCondition);
}
