package com.fbw.controller;


import com.fbw.dao.UserDao;
import com.fbw.domain.ReturnData;
import com.fbw.domain.User;
import com.fbw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public ReturnData login(User user){
        String tocken = iUserService.userLogin(user.getUserName(), user.getPassword());
        if(tocken == ""){
            return new ReturnData("","请先登录",250);
        }
        return new ReturnData(tocken,"登录成功",200);
    }

    @PostMapping("/register")
    public ReturnData register(User user){
        System.out.println(user);
        String msg = iUserService.register(user);
        if (msg == "") {
            return new ReturnData(user,msg,250);
        }
        return new ReturnData(user,msg,200);
    }

    @GetMapping("/info")
    public ReturnData getInfo(HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        return new ReturnData(user,"success",200);
    }

}

