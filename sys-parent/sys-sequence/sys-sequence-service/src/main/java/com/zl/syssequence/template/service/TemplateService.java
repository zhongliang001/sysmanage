package com.zl.syssequence.template.service;

import com.zl.sequence.Template;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface TemplateService {


    /**
     * 查询模板
     * @param name 模板名
     * @return 模板列表
     */
    List<Template> select(String name);

    /**
     * 新增模板
     * @param template 模板
     * @return 新增数量
     */
    int add(Template template);
}
