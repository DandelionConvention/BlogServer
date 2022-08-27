package com.fbw.service.impl;

import com.fbw.domain.Article;
import com.fbw.dao.ArticleDao;
import com.fbw.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public int saveArticle(Article article) {
        article.setCreated(System.currentTimeMillis());
        if(article.getPutTop() != null){
            article.setPutTop("1");
        }else {
            article.setPutTop("0");
        }
        article.setIsPublished("1");
        article.setCommentable("1");
        article.setCommentCount(0);
        article.setHadPublished("1");
        article.setViewCount(1);
        article.setUpdated(System.currentTimeMillis());

        int insert = articleDao.insert(article);

        return insert;
    }

    @Override
    public int updateAricleImage(Article article) {
        int i = articleDao.updateById(article);
        return i;
    }

    @Override
    public List<Article> getAllArticle() {
        List<Article> articles = articleDao.selectList(null);
        return articles;
    }
}
