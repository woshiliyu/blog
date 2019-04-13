package com.ly.provider.sys.Service.impl;


import com.ly.provider.sys.entity.SysOperLog;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ly.provider.sys.dao.SysOperLogDao;
import com.ly.provider.sys.Service.SysOperLogService;


@Service("sysOperLogService")
public class SysOperLogServiceImpl  implements SysOperLogService {

    @Autowired
    private SysOperLogDao sysOperLogDao;
    @Override
    public List<SysOperLog> queryList(Map<String, Object> map) {
        return sysOperLogDao.queryList(map);
    }

    @Override
    public SysOperLog selectById(Integer operId)
    {
        return sysOperLogDao.selectById(operId);
    }


    @Override
    public int insertSysOperLog(SysOperLog sysOperLog)
    {
        return sysOperLogDao.insertSysOperLog(sysOperLog);
    }

    @Override
    public int updateSysOperLog(SysOperLog sysOperLog)
    {
        return sysOperLogDao.updateSysOperLog(sysOperLog);
    }

    @Override
    public int deleteSysOperLogByIds(String ids)
    {
        return sysOperLogDao.deleteSysOperLogByIds(ids);
    }

    @Override
    public int queryTotal(Map<String, Object> map)
    {
        return sysOperLogDao.queryTotal(map);
    }
}
