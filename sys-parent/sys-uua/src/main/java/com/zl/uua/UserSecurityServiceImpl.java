package com.zl.uua;

import com.zl.common.dto.ResultDto;
import com.zl.dto.UserDto;
import com.zl.sysadminfeign.client.AdminFeign;
import com.zl.uua.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.stereotype.Component;

/**
 * @author zhongliang
 */
@Component
public class UserSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private AdminFeign adminFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResultDto<UserDto> query = adminFeign.query(username);
        UserDto data = query.getData();
        UserDomain userDomain = new UserDomain();
        if(data == null){
            throw new UnauthorizedUserException("用户名或密码错误");
        }
        userDomain.setUserDto(data);
        return userDomain;
    }

    public void recodeErrerTimes(String username) {
//        User sysUser = new User();
//        sysUser.setUsername(username);
//        sysUser = sysUserService.selectForLogin(sysUser);
//        Integer errLoginTimes = sysUser.getErrLoginTimes();
//        errLoginTimes = errLoginTimes == null ? 0: errLoginTimes;
//        errLoginTimes ++;
//        sysUser.setErrLoginTimes(errLoginTimes);
//        sysUserService.updateSysUSer(sysUser);
    }
}
