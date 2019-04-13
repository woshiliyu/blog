package com.ly.provider.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.ly.provider.sys.entity.TtMenu;
import com.ly.provider.sys.Service.TtMenuService;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.rest.R;
import  com.ly.common.utils.Query;



/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-15 22:35:27
 */
@RestController
@RequestMapping("sys/ttmenu")
public class TtMenuController {
    @Autowired
    private TtMenuService ttMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Map<String, Object>> list = ttMenuService.queryList(query);
        int total = ttMenuService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);


    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        TtMenu ttMenu = ttMenuService.selectById(id);

        return R.ok().put("ttMenu", ttMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TtMenu ttMenu){
        ttMenuService.insertTtMenu(ttMenu);

        return R.ok();
    }


    /**
     * 修改保存
     */

    @PostMapping("/edit")
    @ResponseBody
    public R editSave(TtMenu ttMenu)
    {
        ttMenuService.updateTtMenu(ttMenu);
        return R.ok();
    }



    /**
     * 删除${tableComment}
     */
    @PostMapping( "/delete")
    @ResponseBody
    public R remove(String ids)
    {
        ttMenuService.deleteTtMenuByIds(ids);
        return R.ok();
    }

}
