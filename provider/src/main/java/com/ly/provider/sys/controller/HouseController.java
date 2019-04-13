package com.ly.provider.sys.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.ModelMap;

import com.ly.provider.sys.entity.House;
import com.ly.provider.sys.Service.HouseService;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.rest.R;
import  com.ly.common.utils.Query;




/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-25 16:14:01
 */
@RestController
@RequestMapping("sys/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 列表
     */
    @RequestMapping("/pagelist")
    public R list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<House> list = houseService.queryList(query);
        int total = houseService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);


    }

    /**
 * 列表
 */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String, Object> params,ModelMap mmap){
        Query query = new Query(params);

        List<House> list = houseService.queryList(query);

        mmap.addAttribute("houses",list);

        return "/article/articleList";
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    public R info(@RequestParam("houseId") Integer houseId){
        House house = houseService.selectById(houseId);

        return R.ok().put("house", house);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save( House house){
        houseService.insertHouse(house);

        return R.ok();
    }


    /**
     * 修改保存
     */

    @PostMapping("/edit")
    @ResponseBody
    public R editSave(House house)
    {
        houseService.updateHouse(house);
        return R.ok();
    }



    /**
     * 删除${tableComment}
     */
    @PostMapping( "/delete")
    @ResponseBody
    public R remove(String ids)
    {
        houseService.deleteHouseByIds(ids);
        return R.ok();
    }

}
