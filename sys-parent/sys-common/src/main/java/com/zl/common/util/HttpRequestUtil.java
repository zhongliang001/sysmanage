package com.zl.common.util;

import com.auth0.jwt.interfaces.Claim;
import com.zl.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * <p>request 工具</p>
 * @author zhongliang
 */
public class HttpRequestUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    /**
     * 从请求中获取当前请求中获取用户信息
     * @return com.zl.domain.User
     */
    public static UserDto getRequestUser(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes !=null) {
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Enumeration<String> headers = request.getHeaders("token");
            if(request.getHeaders("token").hasMoreElements()){
                String token = request.getHeaders("token").nextElement();
                logger.debug("获取到token: {}", token);
                if(StringUtils.isEmpty(token) || "null".equals(token)){
                    return null;
                }
                Map<String, Claim> parse = JwtUtil.parse(token);
                Claim userClaim = parse.get("userDto");
                return userClaim.as(UserDto.class);
            }
        }
       return null;
    }
}
