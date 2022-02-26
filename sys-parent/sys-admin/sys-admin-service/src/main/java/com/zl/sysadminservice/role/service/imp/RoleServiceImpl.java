package com.zl.sysadminservice.role.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import com.zl.domain.Role;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.role.mapper.RoleMapper;
import com.zl.sysadminservice.role.service.RoleService;
import com.zl.sysadminservice.roleright.mapper.RoleRightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * RoleService的实现类
 * @author zhongliang
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     * Role的Mapper
     */
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRightMapper roleRightMapper;

    /**
     * 序列表号生成Feign
     */
    @Autowired
    private SequenceFeign sequenceFeign;

    /**
     * 角色id模板
     */
    private static final String TEMP= "ROLE_TMP";

    /**
     * 根据条件查询角色
     * @param queryCondition 查询条件
     * @return 返回角色列表
     */
    @Override
    public List<Role> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return roleMapper.select(queryCondition.getCondition());
    }

    /**
     * 新增角色
     * @param role 角色
     * @return 新增角色条数
     */
    @Override
    public int add(Role role) {
        try {
            String id = role.getId();
            if(StringUtils.isEmpty(id)){
                ResultDto<String> resultDto = sequenceFeign.getSequnces(TEMP);
                role.setId(resultDto.getData());
                return  roleMapper.add(role);
            }else {
                // 根据id判断数据是否存在，不存在则增加，存在则抛异常
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                List<Role> roles = roleMapper.select(map);
                if(ObjectUtils.isEmpty(roles)){
                    return roleMapper.add(role);
                }else{
                    throw new ZlException(TradeCodeDict.FAILED_ADD_DUP_CODE);
                }
            }
        } catch (ZlException e) {
            e.printStackTrace();
            throw e;
        }catch (Exception e){
            e.printStackTrace();
            throw new ZlException(TradeCodeDict.FAILED_ADD_CODE);
        }
    }

    /**
     * 修改角色
     * @param role 角色
     * @return 修改条数
     */
    @Override
    public int update(Role role) {
        try {
            return roleMapper.update(role);
        } catch (Exception e) {
            throw new ZlException(TradeCodeDict.FAILED_UPDATE_CODE);
        }
    }

    /**
     * 删除角色
     * @param id 角色id
     * @return 删除条数
     */
    @Override
    public int delete(String id) {
        try {
            roleRightMapper.deleteByRoleId(id);
            return roleMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ZlException(TradeCodeDict.FAILED_DELETE_CODE);
        }

    }

    @Override
    public Map<String, List<Map<String,String>>> queryRoleForChoose(String userId){
        Map<String, List<Map<String,String>>> map = new HashMap<>();
        List<Role> choosedRoles = roleMapper.selectChoose(userId);
        List<Map<String,String>> choosedList =   choosedRoles.stream().map(t->{
            Map<String,String> m = new HashMap<>();
            m.put("name", t.getName());
            m.put("value", t.getId());
            return m;
        }).collect(Collectors.toList());
        List<Role> unChoosedRoles = roleMapper.selectUnchoose(userId);
        List<Map<String,String>> unChoosedList =  unChoosedRoles.stream().map(t->{
            Map<String,String> m = new HashMap<>();
            m.put("name", t.getName());
            m.put("value", t.getId());
            return m;
        }).collect(Collectors.toList());
        map.put("chooesedData", choosedList);
        map.put("unchooesedData", unChoosedList);
        return map;
    }
}
