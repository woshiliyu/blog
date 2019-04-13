package com.ly.generator.controller;



import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.Query;
import com.ly.common.utils.rest.R;
import com.ly.generator.service.SysGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午9:12:58
 */
@Controller
public class SysGeneratorController {
	@Autowired
	private SysGeneratorService sysGeneratorService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

//		Result result = new Result();
//		result.setRetCode(Result.RECODE_SUCCESS);
//		try {
//			//查询列表数据
//			Query query = new Query(params);
//			List<Map<String, Object>> list = sysGeneratorService.queryList(query);
//			int total = sysGeneratorService.queryTotal(query);
//
//			PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
//			result.setData(list);
//		}catch (Exception e) {
//			result.setRetCode(Result.RECODE_ERROR);
//		}
//		return  result;
		//查询列表数据
		Query query = new Query(params);
		List<Map<String, Object>> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	@GetMapping("/query")
	public  String query(ModelMap mol){
		mol.addAttribute("name","liy");
		return "gen";
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(String tables, HttpServletResponse response) throws IOException{
		byte[] data = sysGeneratorService.generatorCode(tables.split(","));
		
//		response.reset();
//        response.setHeader("Content-Disposition", "attachment; filename=\"renren.zip\"");
//        response.addHeader("Content-Length", "" + data.length);
//        response.setContentType("application/octet-stream; charset=UTF-8");
//
//        IOUtils.write(data, response.getOutputStream());
	}
}
