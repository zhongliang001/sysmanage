package com.zl.sysadminservice.sdict.mapper;

import com.zl.domain.Sdict;

import java.util.List;

/**
 * @author zhongliang
 */
public interface SdictMapper {
    /**
     * 查询数据字典
     *
     * @param sdict 数据字典
     * @return 数据字典集合
     */
    List<Sdict> selectSdict(Sdict sdict);

    /**
     * 根据字典类型查询数据字典
     *
     * @param sdictType 数据字典类型
     * @return 数据字典集合
     */
    List<String> selctSdictByType(String sdictType);
}
