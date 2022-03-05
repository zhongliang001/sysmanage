package com.zl.syssequence.template.mapper;

import com.zl.sequence.domain.Template;

import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
public interface TemplateMapper {

    /**
     * 查询模板
     * @param map 查询提奥健
     * @return 模板列表
     */
    List<Template> select(Map<String, Object> map);

    /**
     * 删除模板
     * @param  id 模板
     * @return 删除记录数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增模板
     * @param template 模板
     * @return 新增数量
     */
    int add(Template template);

    /**
     * 查询模板
     * @param id 模板id
     * @return 模板
     */
    Template selectByPrimaryKey(String id);

    /**
     * 查询所有模板
     * @return 模板列表
     */
    List<Template> selectAll();

    /**
     * 更新模板
     * @param template 模板
     * @return 返回更新模板数
     */
    int updateByPrimaryKey(Template template);

}
