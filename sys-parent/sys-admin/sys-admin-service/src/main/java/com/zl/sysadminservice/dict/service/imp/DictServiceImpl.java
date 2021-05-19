package com.zl.sysadminservice.dict.service.imp;

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

}
