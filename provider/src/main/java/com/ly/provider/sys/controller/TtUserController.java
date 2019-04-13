package com.ly.provider.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.ModelMap;

import com.ly.provider.sys.entity.TtUser;
import com.ly.provider.sys.Service.TtUserService;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.rest.R;
import  com.ly.common.utils.Query;




/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-23 15:22:38
 */
@RestController
@RequestMapping("sys/ttuser")
public class TtUserController {
    @Autowired
    private TtUserService ttUserService;

    /**
     * 列表
     */
    @RequestMapping("/pagelist")
    public R list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<TtUser> list = ttUserService.queryList(query);
        int total = ttUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);


    }

    /**
 * 列表
 */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String, Object> params,ModelMap mmap){
        Query query = new Query(params);

        List<TtUser> list = ttUserService.queryList(query);

        mmap.addAttribute("ttUsers",list);

        return "/article/articleList";
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    public R info(@RequestParam("userId") Long userId){
        TtUser ttUser = ttUserService.selectById(userId);

        return R.ok().put("ttUser", ttUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save( TtUser ttUser){
        ttUserService.insertTtUser(ttUser);

        return R.ok();
    }


    /**
     * 修改保存
     */

    @PostMapping("/edit")
    @ResponseBody
    public R editSave(TtUser ttUser)
    {
        ttUserService.updateTtUser(ttUser);
        return R.ok();
    }



    /**
     * 删除${tableComment}
     */
    @PostMapping( "/delete")
    @ResponseBody
    public R remove(String ids)
    {
        ttUserService.deleteTtUserByIds(ids);
        return R.ok();
    }

}
