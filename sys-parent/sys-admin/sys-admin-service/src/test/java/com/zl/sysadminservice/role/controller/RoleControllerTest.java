package com.zl.sysadminservice.role.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.SysAdminServiceApplication;
import com.zl.common.domain.QueryCondition;
import com.zl.common.dto.ResultDto;
import com.zl.domain.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysAdminServiceApplication.class)
public class RoleControllerTest {

    private final Logger logger = LoggerFactory.getLogger(RoleControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void select() throws Exception {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setPageSize(5);
        queryCondition.setPageNum(1);
        ObjectMapper mapper=new ObjectMapper();
        String requestBody =mapper.writeValueAsString(queryCondition);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/select").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .param("name", "Tom"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").exists())
//                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);

    }

    @Test
    @Rollback(false)
    public void add() throws Exception{
        Role role = new Role();
        role.setName("角色测试");
        role.setRemark("用来测试新增角色");
        ObjectMapper mapper=new ObjectMapper();
        String requestBody =mapper.writeValueAsString(role);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);


        Role role2 = new Role();
        role2.setId("99999");
        role2.setName("角色测试2");
        role2.setRemark("用来测试新增角色2");
        String requestBody2 =mapper.writeValueAsString(role2);
        MvcResult result2 = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody2)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("000001"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body2 = result2.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body2);
        MvcResult result3 = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody2)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("900004"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body3 = result3.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body3);
    }

    @Test
    @Rollback(false)
    public void update() throws Exception{
        QueryCondition queryCondition = new QueryCondition();
        Map<String, Object> map= new HashMap<String,Object>();
        map.put("name","角色测试");
        queryCondition.setCondtion(map);
        queryCondition.setPageSize(5);
        queryCondition.setPageNum(1);
        ObjectMapper mapper=new ObjectMapper();
        String requestBody =mapper.writeValueAsString(queryCondition);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/select").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .param("name", "Tom"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").exists())
//                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);

        Reader reader = new StringReader(body);
        ResultDto<List> resultDto = mapper.readValue(reader, ResultDto.class);
        List list = resultDto.getData();
        LinkedHashMap lh = (LinkedHashMap)list.get(0);
        String ls = mapper.writeValueAsString(lh);
        Reader readerRole = new StringReader(ls);
        Role role = mapper.readValue(readerRole, Role.class);
        role.setRemark("用来测试修改角色");
        String updateBody =mapper.writeValueAsString(role);
        MvcResult updateResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/update").contentType(MediaType.APPLICATION_JSON_VALUE).content(updateBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String updateResultBody = updateResult.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",updateResultBody);
    }

    @Test
    @Rollback(false)
    public void delete()  throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/delete").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","000008")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);
    }

    @Test
    @Rollback(false)
    public void queryRoleForChoose()  throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/role/queryRoleForChoose").contentType(MediaType.APPLICATION_JSON_VALUE).param("userId","zhong")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);
    }
}