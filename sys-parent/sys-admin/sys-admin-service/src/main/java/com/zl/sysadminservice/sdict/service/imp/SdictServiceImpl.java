package com.zl.sysadminservice.sdict.service.imp;

import com.zl.domain.Sdict;
import com.zl.sysadminservice.sdict.mapper.SdictMapper;
import com.zl.sysadminservice.sdict.service.SdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author zhongliang
 */
@Service
public class SdictServiceImpl implements SdictService {

    @Autowired
    private SdictMapper sdictMapper;
    @Override
    public List<Sdict> selectSdict(Sdict sdict) {
        return sdictMapper.selectSdict(sdict);
    }

    @Override
    public List<String> selctSdictByType(String sdictType) {
        return sdictMapper.selctSdictByType(sdictType);
    }

}
