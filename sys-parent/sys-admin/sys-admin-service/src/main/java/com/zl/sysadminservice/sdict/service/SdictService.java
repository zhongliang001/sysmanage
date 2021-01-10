package com.zl.sysadminservice.sdict.service;

import com.zl.domain.Sdict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SdictService {

    List<Sdict> selectSdict(Sdict sdict);

    List<String> selctSdictByType(String sdictType);
}
