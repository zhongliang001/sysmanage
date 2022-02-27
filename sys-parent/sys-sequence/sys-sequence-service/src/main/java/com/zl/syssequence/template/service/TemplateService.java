package com.zl.syssequence.template.service;

import com.zl.common.domain.QueryCondition;
import com.zl.sequence.domain.Template;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongliang
 */
@Service
public interface TemplateService {


    /**
     * 查询模板
     * @param queryCondition 查询提条件
     * @return 模板列表
     */
    List<Template> select(QueryCondition queryCondition);

    /**
     * 新增模板
     * @param template 模板
     * @return 新增数量
     */
    int add(Template template);

    String getTemplate(String name);
}
