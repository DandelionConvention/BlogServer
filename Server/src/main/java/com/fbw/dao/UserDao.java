package com.fbw.dao;

import com.fbw.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
