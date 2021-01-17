package com.zl.common.util;

import com.zl.common.dto.ResultDto;
import com.zl.common.error.ErrEnum;

public class ResultUtil {

    public static <T>ResultDto genenrate(T t, String errCode){
        ResultDto<T> resultDto = new ResultDto<>();
        resultDto.setData(t);
        formatResponseInfo(resultDto,errCode);
        return resultDto;
    }

    public static <T>ResultDto genenrateByCode(String errDict){
        ResultDto<T> resultDto = new ResultDto<>();
        formatResponseInfo(resultDto,errDict);
        return resultDto;
    }

    private static <T> void formatResponseInfo( ResultDto<T> resultDto, String errDict){
        for(ErrEnum s: ErrEnum.values()){
            if(s.name().equals(errDict)){
                resultDto.setCode(s.getCode());
                resultDto.setMsg(s.getMessage());
                return;
            }
        }
    }

}
