package com.zl.syssequence.template.service.impl;

import com.zl.common.util.DateUtil;
import com.zl.common.util.HttpRequestUtil;
import com.zl.domain.User;
import com.zl.sequence.Template;
import com.zl.syssequence.template.mapper.TemplateMapper;
import com.zl.syssequence.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhongliang
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    /**
     * 查询模板列表
     * @param name 模板名
     * @return 模板列表
     */
    @Override
    public List<Template> select(String name) {
        return templateMapper.select(name);
    }

    /**
     * 新增模板
     * @param template 模板
     * @return 新增数量
     */
    @Override
    public int add(Template template) {
        User user = HttpRequestUtil.getRequestUser();
        template.setCreateUser(user.getUsername());
        template.setCreateTime(DateUtil.format(LocalDateTime.now()));
        return templateMapper.add(template);
    }
}
