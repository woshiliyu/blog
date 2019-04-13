package com.ly.provider.sys.Service;


import com.ly.common.utils.rest.PageUtils;
import com.ly.provider.sys.entity.Article;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-17 15:56:33
 */
public interface ArticleService {

    public List<Article>  queryList(Map<String, Object> map);

    public Article selectById(Integer aid);

    public int insertArticle(Article article);

    public int updateArticle(Article article);

    public int deleteArticleByIds(String ids);

    int queryTotal(Map<String, Object> map);
}

