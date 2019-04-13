package com.ly.provider.sys.Service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.Query;

import com.ly.provider.sys.dao.TtMenuDao;
import com.ly.provider.sys.entity.TtMenu;
import com.ly.provider.sys.Service.TtMenuService;


@Service("ttMenuService")
public class TtMenuServiceImpl  implements TtMenuService {

    @Autowired
    private TtMenuDao ttMenuDao;
    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return ttMenuDao.queryList(map);
    }

    @Override
    public TtMenu selectById(Integer id)
    {
        return ttMenuDao.selectById(id);
    }


    @Override
    public int insertTtMenu(TtMenu ttMenu)
    {
        return ttMenuDao.insertTtMenu(ttMenu);
    }

    @Override
    public int updateTtMenu(TtMenu ttMenu)
    {
        return ttMenuDao.updateTtMenu(ttMenu);
    }

    @Override
    public int deleteTtMenuByIds(String ids)
    {
        return ttMenuDao.deleteTtMenuByIds(ids);
    }

    @Override
    public int queryTotal(Map<String, Object> map)
    {
        return ttMenuDao.queryTotal(map);
    }
}
