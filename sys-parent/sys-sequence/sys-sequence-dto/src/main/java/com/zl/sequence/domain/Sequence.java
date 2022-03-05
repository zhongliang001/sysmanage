package com.zl.sequence.domain;

import java.io.Serializable;

/**
 * <p>
 *     序列对象
 * </p>
 * @author zhongliang
 */
public class Sequence  implements Serializable {

    /**
     * 流水号名
     */
    private String name;

    /**
     * 流水号
     */
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Sequence{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
