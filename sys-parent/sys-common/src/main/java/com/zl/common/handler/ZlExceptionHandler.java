package com.zl.common.handler;

import com.zl.common.exception.ZlException;
import com.zl.common.dto.ResultDto;
import com.zl.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhongliang
 */

@ControllerAdvice(basePackages = "com.zl")
public class ZlExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ZlExceptionHandler.class);

    @ExceptionHandler(ZlException.class)
    @ResponseBody
    ResultDto<String> handleControllerException(HttpServletRequest request, Throwable
            ex) {
        ResultDto<String> resultDto = ResultUtil.genenrateByCode(ex.getMessage());
        logger.error("错误码：{}， 错误信息：{}", ex.getMessage(), resultDto.getMsg());
        ex.printStackTrace();
        return resultDto;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer)
                request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
