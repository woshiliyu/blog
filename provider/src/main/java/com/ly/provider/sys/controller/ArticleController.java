package com.ly.provider.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ly.common.annotation.Log;
import com.ly.common.enums.BusinessType;
import com.ly.common.utils.rest.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.ModelMap;

import com.ly.provider.sys.entity.Article;
import com.ly.provider.sys.Service.ArticleService;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.rest.R;
import  com.ly.common.utils.Query;




/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-17 15:56:33
 */
@Controller
@RequestMapping("sys/article")
public class ArticleController {

    private static Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
    @RequestMapping("/pagelist")
    public Result list(@RequestParam(defaultValue = "1") int page  , @RequestParam(defaultValue = "10") int limit){

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("page",page);
        params.put("limit",limit);
        Query query = new Query(params);

        Result result = new Result();
        result.setRetCode(Result.RECODE_SUCCESS);

        try {
            List<Article> list = articleService.queryList(query);
            int total = articleService.queryTotal(query);
            PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
            result.setData(pageUtil);
        }catch (Exception e){
            System.out.println("aaaa");
            result.setRetCode(Result.RECODE_ERROR);
        }

        return result;


    }

    /**
 * 列表
 */
    @Log(title = "文章列表", businessType = BusinessType.INSERT)
    @RequestMapping("/list")

    public String list(@RequestParam(defaultValue = "1") int page  ,@RequestParam(defaultValue = "10") int limit,ModelMap mmap){

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("page",page);
        params.put("limit",limit);
        Query query = new Query(params);
        List<Article> list = articleService.queryList(query);
        mmap.addAttribute("articles",list);

        return "/article/articleList";
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    public String info(@RequestParam("aid") Integer aid,ModelMap mmap){
        Article article = articleService.selectById(aid);
        mmap.addAttribute("article",article);
        return "/article/articleInfo";
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public String save( Article article){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        articleService.insertArticle(article);


        return "/article/articleList";
    }


    /**
     * 修改保存
     */


    @RequestMapping("/edit")
    public String  editSave(Article article)
    {
        articleService.updateArticle(article);
        return "/article/articleList";
    }



    /**
     * 删除${tableComment}
     */
    @PostMapping( "/delete")
    @ResponseBody
    public R remove(String ids)
    {
        articleService.deleteArticleByIds(ids);
        return R.ok();
    }

}
