package com.zl.dto;

import com.zl.domain.Action;

/**
 * @author zhongliang
 */
public class ActionDto extends Action {

    /**
     * 是否拥有权限
     */
    private Boolean isHasRight;

    public Boolean getHasRight() {
        return isHasRight;
    }

    public void setHasRight(Boolean hasRight) {
        isHasRight = hasRight;
    }
}
