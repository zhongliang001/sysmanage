package com.zl.sysadminservice.action.mapper;

import com.zl.domain.Action;
import java.util.List;

public interface ActionMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Action row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Action selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Action> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Action row);
}