package com.ly.provider.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import com.ly.provider.sys.entity.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.ModelMap;

import com.ly.provider.sys.Service.SysOperLogService;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.rest.R;
import  com.ly.common.utils.Query;




/**
 * 操作日志记录
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-26 14:46:58
 */
@RestController
@RequestMapping("sys/sysoperlog")
public class SysOperLogController {
    @Autowired
    private SysOperLogService sysOperLogService;

    /**
     * 列表
     */
    @RequestMapping("/pagelist")
    public R list(@RequestParam(defaultValue = "1") int page  ,@RequestParam(defaultValue = "10") int limit){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("page",page);
        params.put("limit",limit);
        Query query = new Query(params);
        List<SysOperLog> list = sysOperLogService.queryList(query);
        int total = sysOperLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);


    }

    /**
 * 列表
 */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page  ,@RequestParam(defaultValue = "10") int limit,ModelMap mmap){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("page",page);
        params.put("limit",limit);
        Query query = new Query(params);
        List<SysOperLog> list = sysOperLogService.queryList(query);

        mmap.addAttribute("sysOperLogs",list);

        return "/article/articleList";
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    public R info(@RequestParam("operId") Integer operId){
        SysOperLog sysOperLog = sysOperLogService.selectById(operId);

        return R.ok().put("sysOperLog", sysOperLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save( SysOperLog sysOperLog){
        sysOperLogService.insertSysOperLog(sysOperLog);

        return R.ok();
    }


    /**
     * 修改保存
     */

    @PostMapping("/edit")
    @ResponseBody
    public R editSave(SysOperLog sysOperLog)
    {
        sysOperLogService.updateSysOperLog(sysOperLog);
        return R.ok();
    }



    /**
     * 删除${tableComment}
     */
    @PostMapping( "/delete")
    @ResponseBody
    public R remove(String ids)
    {
        sysOperLogService.deleteSysOperLogByIds(ids);
        return R.ok();
    }

}
