package com.zl.sysadminservice.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.SysAdminServiceApplication;
import com.zl.common.domain.QueryCondition;
import com.zl.domain.User;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysAdminServiceApplication.class)
public class UserControllerTest {

    private final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

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
        Map<String, Object> map = new HashMap<>(16);
        map.put("certType","10");
        queryCondition.setCondtion(map);
        ObjectMapper mapper=new ObjectMapper();
        String requestBody =mapper.writeValueAsString(queryCondition);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/user/select").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
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
    @Rollback
    @Transactional
    public void add() throws Exception {
        User user = new User();
        user.setUsername("ceshi3");
        user.setRealName("测试");
        user.setCertType("1");
        user.setCertNo("123");
        user.setSex("1");
        user.setPhoneNo("1311111111");
        ObjectMapper mapper=new ObjectMapper();
        String requestBody =mapper.writeValueAsString(user);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/user/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);
        MvcResult result2 = mockMvc.perform(MockMvcRequestBuilders
                .post("/user/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("900004"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body2 = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body2);
    }

    @Transactional
    @Rollback
    @Test
    public void delete() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/user/delete").contentType(MediaType.APPLICATION_JSON_VALUE).param("id","test")
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