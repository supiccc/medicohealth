package com.supi.mh.email.restful;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MedicohealthRestfulEmailApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
//        设置MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 模拟POST请求，无需启动Web服务器
     * @throws Exception
     */
    @Test
    public void send2Admin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/email/v1/toadmin")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", "来自MedicohealthRestfulEmailApplicationTests模块的send2Admin"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void contextLoads() {
    }

}
