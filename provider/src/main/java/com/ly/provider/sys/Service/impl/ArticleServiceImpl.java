package com.ly.provider.sys.Service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.Query;

import com.ly.provider.sys.dao.ArticleDao;
import com.ly.provider.sys.entity.Article;
import com.ly.provider.sys.Service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl  implements ArticleService {
    private static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> queryList(Map<String, Object> map) {

        return articleDao.queryList(map);
    }

    @Override
    public Article selectById(Integer aid)
    {
        return articleDao.selectById(aid);
    }


    @Override
    public int insertArticle(Article article)
    {
        return articleDao.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article)
    {
        return articleDao.updateArticle(article);
    }

    @Override
    public int deleteArticleByIds(String ids)
    {
        return articleDao.deleteArticleByIds(ids);
    }

    @Override
    public int queryTotal(Map<String, Object> map)
    {
        return articleDao.queryTotal(map);
    }
}
