package com.fbw.service;

import com.fbw.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
public interface IArticleService {

    int saveArticle(Article article);

    int updateAricleImage(Article article);

    List<Article> getAllArticle();

}
