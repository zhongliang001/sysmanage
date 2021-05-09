package com.zl.sysadminfeign.client;

import com.zl.common.dto.ResultDto;
import com.zl.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhongliang
 */
@FeignClient(name = "sys-admin-service")
@RequestMapping("/user")
public interface AdminFeign {

    @PostMapping("/query")
    ResultDto<User> query(@RequestBody String username);

}