package com.fbw.server;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class nomerTest {

    @Test
    public void doTest(){
        String n = "E:\\Codes\\javaCodes\\BlogServer\\Server\\src\\main\\resources\\static\\upload\\imgs\\blog(1).sql";
        String[] split = n.split("\\\\static");
        System.out.println(split[1].replace('\\','/'));
    }

    @Test
    public void doMd5() {
        String password = "123";
        try {
            password = String.valueOf(DigestUtils.md5DigestAsHex(password.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(password);
    }

    @Test
    public void tttt(){
        String f = "annas.jpg";
        String[] split = f.split("\\.");
        for(String s:split){
            System.out.println(s);
        }
    }
}
