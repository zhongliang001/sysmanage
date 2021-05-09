package com.zl.uua.domain;

import com.zl.common.util.DateUtil;
import com.zl.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author zhongliang
 * @version 1.0.1
 */
public class UserDomain implements UserDetails {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        Integer errLoginTimes = user.getErrLoginTimes();
        if (errLoginTimes == null) {
            return true;
        }
        return errLoginTimes < 3;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (!StringUtils.isEmpty(user.getForbiddenLoginTime()) && !StringUtils.isEmpty(user.getForbiddenLoginPeriod())) {
            try {
                Date date = DateUtil.addDay(user.getForbiddenLoginTime(), user.getForbiddenLoginPeriod());
                int i = DateUtil.compareDate(new Date(), date);
                return false;
            } catch (ParseException e) {
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


}
