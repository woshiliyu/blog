package com.ly.provider.sys.dao;

import com.ly.provider.sys.controller.ArticleController;
import com.ly.provider.sys.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.List;



/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-17 15:56:33
 */
public interface ArticleDao  {

    List<Article> queryList(Map<String, Object> map);

    public Article selectById(Integer aid);

    public int insertArticle(Article article);

    public int updateArticle(Article article);

    public int deleteArticleByIds(String ids);

    int queryTotal(Map<String, Object> map);
}
