package com.zl.sysadminservice.sdict.service;

import com.zl.domain.Sdict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface SdictService {

    /**
     * 查询数据字典
     * @param sdict 字典对象
     * @return 字典集合
     */
    List<Sdict> selectSdict(Sdict sdict);

    /**
     * 根据字典类型查询数据字典
     * @param sdictType 字典类型
     * @return 字典集合
     */
    List<String> selctSdictByType(String sdictType);
}
