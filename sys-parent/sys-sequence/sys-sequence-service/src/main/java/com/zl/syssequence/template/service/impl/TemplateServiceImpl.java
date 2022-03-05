package com.zl.syssequence.template.service.impl;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.exception.ZlException;
import com.zl.common.util.DateUtil;
import com.zl.common.util.HttpRequestUtil;
import com.zl.dto.UserDto;
import com.zl.sequence.domain.Template;
import com.zl.syssequence.service.SequenceService;
import com.zl.syssequence.template.mapper.TemplateMapper;
import com.zl.syssequence.template.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    private final Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    @Resource(name="${sequenceService}")
    private SequenceService sequenceService;

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
    @Transactional(rollbackFor = ZlException.class)
    public int add(Template template) {
        logger.info("接收到新增模板请求：{}", template);
        UserDto userDto = HttpRequestUtil.getRequestUser();
        if (userDto == null) {
           throw new ZlException("你暂时无法进行当前操作，请重新登录后再尝试！");
        }
        String temp = "TEMPLATE_TEP";
        String id = sequenceService.fomartSeqence(getTemplate(temp));
        template.setId(id);
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

    @Override
    public int update(Template template) {
        logger.info("接收到修改模板请求：{}", template);
        UserDto userDto = HttpRequestUtil.getRequestUser();
        if (userDto == null) {
            throw new ZlException("你暂时无法进行当前操作，请重新登录后再尝试！");
        }
        template.setUpdateUser(userDto.getUsername());
        template.setUpdateTime(DateUtil.format(LocalDateTime.now()));
        return templateMapper.updateByPrimaryKey(template);
    }

    @Override
    public int delete(String id) {
        return templateMapper.deleteByPrimaryKey(id);
    }
}
