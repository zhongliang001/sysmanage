package com.zl.dto;

import com.zl.domain.Sdict;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * @author zhongliang
 */
public class SdictDto implements Serializable {

    private Map<String,List<Sdict>> dictData;

    public Map<String, List<Sdict>> getDictData() {
        return dictData;
    }

    public void setDictData(Map<String, List<Sdict>> dictData) {
        this.dictData = dictData;
    }

    @Override
    public String toString() {
        return "SdictDto{" +
                "dictData=" + dictData +
                '}';
    }
}
