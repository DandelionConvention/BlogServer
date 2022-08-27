package com.fbw.controller;


import com.fbw.domain.Article;
import com.fbw.domain.ReturnData;
import com.fbw.domain.User;
import com.fbw.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    IArticleService iArticleService;

    @PostMapping("/send")
    public ReturnData sendArticle(Article article, HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        article.setAuthorId(user.getOId());
        int i = iArticleService.saveArticle(article);
        return new ReturnData(article,"66666",200);
    }

    @GetMapping("/all")
    public ReturnData getAllArticle(){
        List<Article> allArticle = iArticleService.getAllArticle();
        return new ReturnData(allArticle,"success",200);
    }

}

