package com.zl.sysadminservice.sdict.mapper;

import com.zl.domain.Sdict;

import java.util.List;

public interface SdictMapper {
    List<Sdict> selectSdict(Sdict sdict);

    List<String> selctSdictByType(String dictType);
}
