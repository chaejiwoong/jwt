package redis.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:web/WEB-INF/applicationContext.xml", "file:web/WEB-INF/dispatcher-servlet.xml"})
@Log4j
@WebAppConfiguration    // 컨트롤러 테스트, WebApplicationContext 획득
public class AuthControllerTest {

    @Autowired
    private WebApplicationContext ctx;  // 스프링 컨테이너

    private MockMvc mockMvc;    // 가상의 톰캣(was 대체)

    // 테스트 실행 전 목 객체 초기화
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); // 목객체에 컨테이너 주입
    }

    @Test
    public void testList() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
                                .param("pageNum", "3")
                                .param("amount", "20"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
        );

    }
}