package com.zl.sys.sequence.feign.client;

import com.zl.common.dto.ResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhongliang
 */
@FeignClient("sys-sequence-service")
@RequestMapping("/sequence")
public interface SequenceFeign {
    /**
     * 获取流水号
     * @param name 流水号模板名
     * @return 流水号
     */
    @PostMapping("/getsequnces")
    ResultDto<String> getSequnces(@RequestBody String name);
}
