package com.zl.common.util;

import com.github.pagehelper.PageInfo;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeEnum;

import java.util.List;

/**
 * @author zhongliang
 */
public class ResultUtil {

    @SuppressWarnings("unchecked")
    public static <T> ResultDto<T> genenrate(T t, String errCode) {
        ResultDto<T> resultDto = new ResultDto<>();
        resultDto.setData(t);
        if(t instanceof List){
            PageInfo<T> list = new PageInfo<>((List<T>) t);
            resultDto.setPageNum(list.getPageNum());
            resultDto.setPageSize(list.getPageSize());
            resultDto.setTotal(list.getTotal());
        }
        formatResponseInfo(resultDto, errCode);
        return resultDto;
    }

    public static <T> ResultDto<T> genenrateByCode(String errDict) {
        ResultDto<T> resultDto = new ResultDto<>();
        formatResponseInfo(resultDto, errDict);
        return resultDto;
    }

    private static <T> void formatResponseInfo(ResultDto<T> resultDto, String errDict) {
        for (TradeCodeEnum s : TradeCodeEnum.values()) {
            if (s.name().equals(errDict)) {
                resultDto.setCode(s.getCode());
                resultDto.setMsg(s.getMessage());
                return;
            }
        }
    }

}
