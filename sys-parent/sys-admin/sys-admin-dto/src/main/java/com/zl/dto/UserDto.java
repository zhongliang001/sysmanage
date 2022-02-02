package com.zl.dto;

import com.zl.domain.Role;
import com.zl.domain.User;

import java.util.List;

/**
 * @author zhongliang
 */
public class UserDto extends User {
    /**
     * 用户角色
     */
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDto{" + super.toString()+
                "roles=" + roles +
                '}';
    }
}
