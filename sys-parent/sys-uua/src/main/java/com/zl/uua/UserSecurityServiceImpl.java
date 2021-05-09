package com.zl.uua;

import com.zl.common.dto.ResultDto;
import com.zl.domain.User;
import com.zl.sysadminfeign.client.AdminFeign;
import com.zl.uua.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author zhongliang
 */
@Component
public class UserSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private AdminFeign AdminFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResultDto<User> query = AdminFeign.query(username);
        User data = query.getData();
        UserDomain sd = new UserDomain();
        sd.setUser(data);
        return sd;
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
