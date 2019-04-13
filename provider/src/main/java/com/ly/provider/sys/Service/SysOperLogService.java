package com.ly.provider.sys.Service;


;

import com.ly.provider.sys.entity.SysOperLog;


import java.util.List;
import java.util.Map;

/**
 * 操作日志记录
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-26 14:46:58
 */
public interface SysOperLogService {

    public List<SysOperLog>  queryList(Map<String, Object> map);

    public SysOperLog selectById(Integer operId);

    public int insertSysOperLog(SysOperLog sysOperLog);

    public int updateSysOperLog(SysOperLog sysOperLog);

    public int deleteSysOperLogByIds(String ids);

    int queryTotal(Map<String, Object> map);
}

