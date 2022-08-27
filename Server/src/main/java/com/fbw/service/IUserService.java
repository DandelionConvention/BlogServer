package com.fbw.service;

import com.fbw.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
public interface IUserService {

    String imgUpload(File file, byte[] bytes,Integer id);

    String userLogin(String userName,String password);

    User selectById(int id);

    String register(User user);
}
