package com.zl.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author zhongliang
 */
@Component
public class MD5Util {

    @Value("md5.key")
    private String key;

    public String encryption(String password){
        String base = password +"/"+password;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
