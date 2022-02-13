package com.zl.sysadminservice.menu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.SysAdminServiceApplication;
import com.zl.common.domain.QueryCondition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysAdminServiceApplication.class)
public class MenuControllerTest {

    private Logger logger = LoggerFactory.getLogger(MenuControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void selectByRole() throws Exception{
        QueryCondition queryCondition = new QueryCondition();
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", "000009");
        queryCondition.setCondtion(map);
        ObjectMapper mapper=new ObjectMapper();
        String requestBody =mapper.writeValueAsString(queryCondition);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/menu/selectByRole").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .param("name", "Tom"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
//                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);
    }
}
