package redis.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.controller.dto.MemberRequestDto;
import redis.domain.Member;
import redis.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberMapper mapper;

    @Test
    public void testAdmin (){

        mapper.save(new Member("admin", "admin", "ROLE_ADMIN"));
    }

    @Test
    public void test() {

        authService.signup(new MemberRequestDto("test@hello.net", "test"));
    }

    @Test
    public void testLogin() {
        authService.login(new MemberRequestDto("test@hello.net", "test"));
    }

}