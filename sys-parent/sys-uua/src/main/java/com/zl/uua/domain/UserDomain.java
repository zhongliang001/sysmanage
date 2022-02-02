package com.zl.uua.domain;

import com.zl.common.util.DateUtil;
import com.zl.dto.UserDto;
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

    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String getPassword() {
        return userDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        Integer errLoginTimes = userDto.getErrLoginTimes();
        if (errLoginTimes == null) {
            return true;
        }
        return errLoginTimes < 3;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (!StringUtils.isEmpty(userDto.getForbiddenLoginTime()) && !StringUtils.isEmpty(userDto.getForbiddenLoginPeriod())) {
            try {
                Date date = DateUtil.addDay(userDto.getForbiddenLoginTime(), userDto.getForbiddenLoginPeriod());
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
