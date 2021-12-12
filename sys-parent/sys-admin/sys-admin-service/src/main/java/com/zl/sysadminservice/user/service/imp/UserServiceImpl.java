package com.zl.sysadminservice.user.service.imp;

import com.github.pagehelper.PageHelper;
import com.zl.common.domain.QueryCondition;
import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import com.zl.common.util.MD5Util;
import com.zl.domain.User;
import com.zl.sys.sequence.feign.client.SequenceFeign;
import com.zl.sysadminservice.user.mapper.UserMapper;
import com.zl.sysadminservice.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhongliang
 */

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MD5Util MD5Util;

    @Autowired
    private SequenceFeign sequenceFeign;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 登录
     * @param loginUser 登录用户
     * @return 返回用户信息
     */
    @Override
    public User selectForLogin(User loginUser) {
        String username = loginUser.getUsername();
        return userMapper.selectByUsername(username);
    }

    /**
     * 注册用户
     *
     * @param user 用户
     * @return 插入数据量
     */
    @Transactional(rollbackFor = ZlException.class)
    @Override
    public int register(User user) {
        setUserId(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try {
            return userMapper.add(user);

        } catch (Exception e) {
            logger.info("新增失败：{}", e.getMessage());
            e.printStackTrace();
            throw new ZlException(TradeCodeDict.FAILED_ADD_CODE);
        }
    }

    @Override
    public List<User> select(QueryCondition queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(), queryCondition.getPageSize());
        return userMapper.select(queryCondition.getCondition());
    }

    @Transactional(rollbackFor = ZlException.class)
    @Override
    public int add(User user) {
        setUserId(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getUsername()));
        if(checkUserExists(user.getUsername())){
            throw  new ZlException(TradeCodeDict.FAILED_ADD_DUP_CODE);
        }
        try {
            return userMapper.add(user);

        } catch (Exception e) {
            logger.info("新增失败：{}", e.getMessage());
            e.printStackTrace();
            throw new ZlException(TradeCodeDict.FAILED_ADD_CODE);
        }
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    /**
     * 刪除用戶
     * @param id 用戶id
     * @return 返回删除条数
     */
    @Override
    public int delete(String id) {
        return userMapper.delete(id);
    }

    /**
     *  生成用户id
     * @param user 用户
     */
    private void setUserId(User user) {
        String id = sequenceFeign.getSequnces("USER_SEQ").getData();
        user.setId(id);
    }

    private boolean checkUserExists(String userName){
        User user = userMapper.selectByUsername(userName);
        return user != null;
    }
}
