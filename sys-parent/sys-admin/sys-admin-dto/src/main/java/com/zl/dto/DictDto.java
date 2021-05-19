package com.zl.dto;

import com.zl.domain.Dict;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
public class DictDto implements Serializable {

    private Map<String, List<Dict>> dictData;

    public Map<String, List<Dict>> getDictData() {
        return dictData;
    }

    public void setDictData(Map<String, List<Dict>> dictData) {
        this.dictData = dictData;
    }

    @Override
    public String toString() {
        return "DictDto{" +
                "dictData=" + dictData +
                '}';
    }
}
