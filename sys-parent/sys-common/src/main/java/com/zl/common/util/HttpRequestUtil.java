package com.zl.common.util;

import com.auth0.jwt.interfaces.Claim;
import com.zl.dto.UserDto;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>request 工具</p>
 * @author zhongliang
 */
public class HttpRequestUtil {

    /**
     * 从请求中获取当前请求中获取用户信息
     * @return com.zl.domain.User
     */
    public static UserDto getRequestUser(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes !=null) {
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeaders("token").nextElement();
            Map<String, Claim> parse = JwtUtil.parse(token);
            Claim userClaim = parse.get("userDto");
            return userClaim.as(UserDto.class);
        }
       return null;
    }
}
