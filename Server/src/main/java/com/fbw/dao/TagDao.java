package com.fbw.dao;

import com.fbw.domain.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Mapper
public interface TagDao extends BaseMapper<Tag> {

}
