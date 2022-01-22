package com.zl.dto;

import com.zl.domain.Menu;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单权限
 * @author zhongliang
 */
public class MenuRightDto extends Menu implements Serializable {
    /**
     * 操作集合
     */
    private List<ActionDto> actionDtos;

    public List<ActionDto> getActionDtos() {
        return actionDtos;
    }

    public void setActionDtos(List<ActionDto> actionDtos) {
        this.actionDtos = actionDtos;
    }
}
