package sc.whorl.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SystemWebTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getMenu() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Authorization", "Bearer-eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZW5zc2ljIiwiSldUX0xPR0lOX05BTUUiOiJzZW5zc2ljIiwiSldUX0xPR0lOX1RJTUUiOjE1NDY4NTkzNDkzMzEsIkpXVF9MT0dJTl9VU0VSSUQiOjEsIkpXVF9MT0dJTl9VU0VSVFlQRSI6IlVzZXIiLCJleHAiOjE1NDk0NTEzNDksImlhdCI6MTU0Njg1OTM0OSwianRpIjoiNDJiNTQ0YzctMzRjNC00Mjc4LWFhZWMtNTU5MmQzYmJkM2ZjIn0.mq5NTHdrmmKke_bgQ6YOssbaaYfL1lGvft2E7Eq9SCE");
        mvc.perform(MockMvcRequestBuilders.post("/sc/user/system/getMenu").
                headers(httpHeaders).
                accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print()).
                andReturn();

    }

}