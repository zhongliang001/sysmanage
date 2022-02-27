package com.zl.syssequence.template.service.impl;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.exception.ZlException;
import com.zl.common.util.DateUtil;
import com.zl.common.util.HttpRequestUtil;
import com.zl.dto.UserDto;
import com.zl.sequence.domain.Template;
import com.zl.syssequence.template.mapper.TemplateMapper;
import com.zl.syssequence.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    /**
     * 查询模板列表
     * @param queryCondition 查询条件
     * @return 模板列表
     */
    @Override
    public List<Template> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return templateMapper.select(queryCondition.getCondition());
    }

    /**
     * 新增模板
     * @param template 模板
     * @return 新增数量
     */
    @Override
    public int add(Template template) {
        UserDto userDto = HttpRequestUtil.getRequestUser();
        if (userDto == null) {
           throw new ZlException("你暂时无法进行当前操作，请重新登录后再尝试！");
        }
        template.setCreateUser(userDto.getUsername());
        template.setCreateTime(DateUtil.format(LocalDateTime.now()));
        return templateMapper.add(template);
    }

    @Override
    public String getTemplate(String name) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", name);
        List<Template> templates = templateMapper.select(map);
        if(templates != null && templates.size() > 0){
            return templates.get(0).getTemp();
        }
        return null;
    }
}
