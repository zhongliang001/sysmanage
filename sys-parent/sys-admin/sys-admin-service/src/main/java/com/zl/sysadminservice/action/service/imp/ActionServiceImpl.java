package com.zl.sysadminservice.action.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.domain.Action;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.action.mapper.ActionMapper;
import com.zl.sysadminservice.action.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class ActionServiceImpl implements ActionService {

    private final  static String ACTION_TMP = "ACTION_TMP";
    @Autowired
    private ActionMapper actionMapper;

    @Autowired
    private SequenceFeign sequenceFeign;
    @Override
    public int deleteByPrimaryKey(String id) {
        return actionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Action action) {
        String id = action.getId();
        if (id == null) {
            id = sequenceFeign.getSequnces(ACTION_TMP).getData();
            action.setId(id);
        }
        return actionMapper.insert(action);
    }

    @Override
    public Action selectByPrimaryKey(String id) {
        return actionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Action> selectAll() {

        return actionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Action action) {
        return actionMapper.updateByPrimaryKey(action);
    }

    @Override
    public List<Action> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return actionMapper.select(queryCondition.getCondition());
    }
}
