package com.zl.sysadminservice.dict.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.service.RedisService;
import com.zl.common.util.DateUtil;
import com.zl.domain.Dict;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.dict.mapper.DictMapper;
import com.zl.sysadminservice.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhongliang
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private SequenceFeign sequenceFeign;

    @Autowired
    public RedisService redisService;

    @Override
    public List<Dict> selectSdict(Dict sdict) {
        return dictMapper.selectSdict(sdict);
    }

    @Override
    @SuppressWarnings(value={"unchecked", "rawtypes"})
    public Map<String, Map<String, String>> selectSdictTree(String sdictType) {
        Map map = redisService.getEntries("dictMap");
        if(map == null || map.isEmpty()){
            List<String> sdictTypes = dictMapper.selctSdictByType(sdictType);
            Map<String, Map<String, String>> dictData = new HashMap<>(16);
            for (String type : sdictTypes) {
                Dict sdict = new Dict();
                sdict.setDictType(type);
                List<Dict> sdicts = dictMapper.selectSdict(sdict);
                Map<String, String> dictMap = sdicts.stream().collect(Collectors.toMap(Dict::getCnName, Dict::getEnName));
                dictData.put(type, dictMap);
            }
            redisService.putAll("dictMap",dictData);
            return dictData;
        }else {
            return map;
        }

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
        dict.setCreateTime(DateUtil.format(LocalDateTime.now()));
        dict.setUpdateTime(DateUtil.format(LocalDateTime.now()));
        return dictMapper.save(dict);
    }

    @Override
    public int delDict(String id) {
        return dictMapper.delDict(id);
    }

    @Override
    public int delete(String dictType) {
        return dictMapper.delete(dictType);
    }

    @Override
    public int update(Dict dict) {
        return dictMapper.update(dict);
    }

    @Override
    public int updateDict(Dict dict) {
        return dictMapper.updateDict(dict);
    }

    @Override
    public void clearRedisDict() {
        redisService.delete("dictMap");
    }
}
