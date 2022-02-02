package com.zl.sysadminservice.dict.controller;

import com.zl.SysAdminServiceApplication;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysAdminServiceApplication.class)
public class DictControllerTest {

    private final Logger logger = LoggerFactory.getLogger(DictControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void selectSdictTree() throws Exception{

//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                .post("/dict/dictTree").contentType(MediaType.APPLICATION_JSON_VALUE).param("sdictType","")
//                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
//                .accept(MediaType.APPLICATION_JSON_UTF8))
////                .param("name", "Tom"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0]").exists())
////                .andExpect(MockMvcResultMatchers.status().isOk()) //400错误请求
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/dict/dictTree").contentType(MediaType.APPLICATION_JSON_VALUE)
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
    public void reloadRedisDict() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/dict/reloadRedisDict").contentType(MediaType.APPLICATION_JSON_VALUE)
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("000002"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        logger.info("获取到返回数据：{}",body);
    }
}