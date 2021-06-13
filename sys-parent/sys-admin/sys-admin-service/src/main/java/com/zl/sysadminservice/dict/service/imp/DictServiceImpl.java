package com.zl.sysadminservice.dict.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.domain.Dict;
import com.zl.sysadminservice.dict.mapper.DictMapper;
import com.zl.sysadminservice.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<Dict> selectSdict(Dict sdict) {
        return dictMapper.selectSdict(sdict);
    }

    @Override
    public List<String> selctSdictByType(String sdictType) {
        return dictMapper.selctSdictByType(sdictType);
    }

    @Override
    public List<Dict> selectGroup(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return dictMapper.selectGroup(queryCondition.getCondition());
    }


}
