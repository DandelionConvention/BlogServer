package com.fbw.intercepter;

import com.fbw.domain.User;
import com.fbw.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

@Component
public class LoginIntercepter  implements HandlerInterceptor {
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if (method.equals("POST") || method.equals("GET")){
            String token = request.getHeader("Authorization");
            System.out.println("token----------------------->"+token);
            if(token == null){
                response.setStatus(200);
                response.setContentType("text/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("{\"code\":250,\"msg\":\"滚去登录\"}");
                out.close();
                return false;
            }
            Object user = jwtUtils.verify(token);
            if(user == null){
                response.setStatus(200);
                response.setContentType("text/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("{\"code\":250,\"msg\":\"滚去登录\"}");
                out.close();
                return false;
            }
            request.setAttribute("user",user);
        }
        return true;
    }
}
