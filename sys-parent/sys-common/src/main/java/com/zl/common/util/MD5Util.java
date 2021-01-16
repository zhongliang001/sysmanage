package com.zl.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class MD5Util {

    @Value("md5.key")
    private String key;

    public String encryption(String password){
        String base = password +"/"+password;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
