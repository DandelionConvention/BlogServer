package com.fbw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fbw.dao.ArticleDao;
import com.fbw.dao.UserDao;
import com.fbw.domain.Article;
import com.fbw.domain.User;
import com.fbw.service.IUserService;
import com.fbw.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDao userDao;

    @Autowired
    ArticleDao articleDao;

    @Override
    public String imgUpload(File file, byte[] bytes,Integer id) {
        //先判断登录身份
        //将上传信息路径写入到数据库
        OutputStream os = null;

        try {
            os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "文件保存失败";
        }

        String FName = file.getName();

        //更新图片

        Article article = new Article();
        article.setOId(id);
        article.setImgName(FName);

        int i = articleDao.updateById(article);

        if(i != 1){
            return "";
        }

        return FName;
    }

    @Override
    public String userLogin(String userName,String password) {
        try {
            password = String.valueOf(DigestUtils.md5DigestAsHex(password.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.like(User::getUserName,userName).like(User::getPassword,password);
        User user = userDao.selectOne(qw);

        if(user == null){
            return "";
        }

        String token = jwtUtils.createToken(user);

        return token;
    }

    @Override
    public User selectById(int id) {
        User user = userDao.selectById(id);
        return user;
    }

    @Override
    public String register(User user) {
        String userName = user.getUserName();
        //判断重名

        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.like(User::getUserName,userName);
        if(userDao.selectOne(qw) != null){
            return "用户名占用";
        }

        String pwd = user.getPassword();
        try {
            pwd = String.valueOf(DigestUtils.md5DigestAsHex(pwd.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setPassword(pwd);
        int insert = userDao.insert(user);
        if (insert == 1){
            return "添加成功";
        }
        return "添加失败";
    }


}
