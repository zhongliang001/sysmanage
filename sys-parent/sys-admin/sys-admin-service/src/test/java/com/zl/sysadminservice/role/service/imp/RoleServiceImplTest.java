package com.zl.sysadminservice.role.service.imp;

import com.zl.SysAdminServiceApplication;
import com.zl.common.domain.QueryCondition;
import com.zl.domain.Role;
import com.zl.sysadminservice.role.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysAdminServiceApplication.class)
public class RoleServiceImplTest {

    @Resource
    private RoleService roleService;

    @Test
    @Transactional
    @Rollback()
    public void select() {
        add();
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setPageNum(1);
        queryCondition.setPageSize(5);
        List<Role> roles = roleService.select(queryCondition);
        Assert.assertNotEquals(0, roles.size());
        Role role = roles.get(0);
        int update = update(role);
        Assert.assertNotEquals(0, update);
        List<Role> roles2= roleService.select(queryCondition);
        Assert.assertEquals("测试修改", roles2.get(0).getRemark());
        int del = delete(role.getId());
        Assert.assertNotEquals(0, del);
        List<Role> roles3= roleService.select(queryCondition);
        Assert.assertEquals(1 , roles.size() -roles3.size());
    }

    public void add(){
        Role role = new Role();
        role.setName("系统管理员");
        role.setRemark("可以进行系统相关操作");
        roleService.add(role);
    }

    public int update(Role role){
        role.setRemark("测试修改");
        return roleService.update(role);
    }

    public int delete(String id){
       return roleService.delete(id);
    }
}