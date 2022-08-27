package com.fbw.dao;

import com.fbw.domain.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {

}
