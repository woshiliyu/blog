package com.ly.generator.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * @author ly
 * @email 513422479@qq.com
 * * @date 2018年12月19日
 */
@Mapper
public interface SysGeneratorDao {
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(@Param("tableName") String tableName);
	
	List<Map<String, String>> queryColumns(@Param("tableName")  String tableName);
}
