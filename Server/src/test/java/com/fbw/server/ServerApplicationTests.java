package com.fbw.server;

import com.fbw.dao.UserDao;
import com.fbw.domain.User;
import com.fbw.service.IUserService;
import com.fbw.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Autowired
    JwtUtils jwtUtils;

    @Test
    void testUtils(){
        User user = new User();
        user.setOId(1);
        user.setUserName("adimin");
        String tokenString = jwtUtils.createToken(user);
        System.out.println(tokenString);
        jwtUtils.verify(tokenString);
    }

    @Autowired
    IUserService iUserService;

    @Test
    void testUser() throws UnsupportedEncodingException {
//        User user = iUserService.userLogin("admin", "123");
//        System.out.println(user);
    }

}
