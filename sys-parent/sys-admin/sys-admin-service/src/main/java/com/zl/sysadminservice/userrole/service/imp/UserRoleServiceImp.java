package com.zl.sysadminservice.userrole.service.imp;

import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import com.zl.domain.UserRole;
import com.zl.dto.UserRoleDto;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.userrole.mapper.UserRoleMapper;
import com.zl.sysadminservice.userrole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
@Service
public class UserRoleServiceImp implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private SequenceFeign sequenceFeign;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRole userRole) {
        return userRoleMapper.insert(userRole);
    }

    @Override
    public UserRole selectByPrimaryKey(String id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserRole> selectAll() {
        return userRoleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserRole userRole) {
        return userRoleMapper.updateByPrimaryKey(userRole);
    }

    @Override
    public void config(UserRoleDto userRoleDto) throws ZlException{
        String userId = userRoleDto.getId();
        if(StringUtils.isEmpty(userId)){
            throw new ZlException(TradeCodeDict.ERROR_DATA);
        }
        userRoleMapper.deleteByUserId(userId);
        List<Map<String, String>> mlist = userRoleDto.getList();
        List<UserRole> list = new ArrayList<>();
        mlist.forEach(map->{
            UserRole userRole = new UserRole();
            userRole.setId(sequenceFeign.getSequnces("USERROLE_TMP").getData());
            userRole.setUserId(userId);
            userRole.setRoleId(map.get("value"));
            list.add(userRole);
        });
        if(list.size() > 0){
            userRoleMapper.insertBatch(list);
        }
    }
}
