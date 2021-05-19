package com.zl.common.interceptor;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author zhongliang
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    // 会话ID
    private final static String SESSION_ID = "sessionId";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        String logid = httpServletRequest.getHeader("logid");
        if(StringUtils.isEmpty(logid)){
            logid = UUID.randomUUID().toString().replaceAll("-", "");
            httpServletRequest.setAttribute("logid", logid);
        }
        MDC.put(SESSION_ID, logid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        MDC.remove(SESSION_ID);

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }
}
