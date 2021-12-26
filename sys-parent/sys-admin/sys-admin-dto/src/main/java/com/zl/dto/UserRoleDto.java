package com.zl.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户角色对象
 * @author zhongliang
 */
public class UserRoleDto implements Serializable {

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户角色列表
     */
    private List<Map<String, String>> list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }
}
