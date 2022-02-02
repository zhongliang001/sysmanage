package com.zl.sysadminservice.user.mapper;

import com.zl.domain.User;
import com.zl.dto.UserDto;

import java.util.List;
import java.util.Map;

/**
 * @author zhongliang
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    UserDto selectByUsername(String username);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入数据量
     */
    int add(User user);

    /**
     * 查询用户列表
     * @param condtion 查询条件
     * @return 查询用户列表
     */
    List<User> select(Map<String, Object> condtion);

    /**
     * 修改用户
     * @param user 用户信息
     * @return 修改数量
     */
    int update(User user);

    /**
     * 刪除用戶
     * @param id 用戶id
     * @return 返回删除条数
     */
    int delete(String id);
}
