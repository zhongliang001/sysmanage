package com.zl.sysadminservice.dict.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.util.DateUtil;
import com.zl.domain.Dict;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.dict.mapper.DictMapper;
import com.zl.sysadminservice.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private SequenceFeign sequenceFeign;

    @Override
    public List<Dict> selectSdict(Dict sdict) {
        return dictMapper.selectSdict(sdict);
    }

    @Override
    public List<String> selctSdictByType(String sdictType) {
        return dictMapper.selctSdictByType(sdictType);
    }

    @Override
    public List<Dict> selectGroups(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return dictMapper.selectGroup(queryCondition.getCondition());
    }

    @Override
    public List<Dict> selectGroup(Map<String, Object> condition) {
        return dictMapper.selectGroup(condition);
    }

    @Override
    public List<Dict> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return dictMapper.select(queryCondition.getCondition());
    }

    @Override
    public int save(Dict dict) {
        ResultDto<String> ditId = sequenceFeign.getSequnces("DICT_TMP");
        dict.setId(ditId.getData());
        dict.setCreateTime(DateUtil.format(new Date()));
        dict.setUpdateTime(DateUtil.format(new Date()));
        return dictMapper.save(dict);
    }

    @Override
    public int delDict(String id) {
        return dictMapper.delDict(id);
    }


}
