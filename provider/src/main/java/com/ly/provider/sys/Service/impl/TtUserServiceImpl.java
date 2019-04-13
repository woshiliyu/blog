package com.ly.provider.sys.Service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.Query;

import com.ly.provider.sys.dao.TtUserDao;
import com.ly.provider.sys.entity.TtUser;
import com.ly.provider.sys.Service.TtUserService;


@Service("ttUserService")
public class TtUserServiceImpl  implements TtUserService {

    @Autowired
    private TtUserDao ttUserDao;
    @Override
    public List<TtUser> queryList(Map<String, Object> map) {
        return ttUserDao.queryList(map);
    }

    @Override
    public TtUser selectById(Long userId)
    {
        return ttUserDao.selectById(userId);
    }


    @Override
    public int insertTtUser(TtUser ttUser)
    {
        return ttUserDao.insertTtUser(ttUser);
    }

    @Override
    public int updateTtUser(TtUser ttUser)
    {
        return ttUserDao.updateTtUser(ttUser);
    }

    @Override
    public int deleteTtUserByIds(String ids)
    {
        return ttUserDao.deleteTtUserByIds(ids);
    }

    @Override
    public int queryTotal(Map<String, Object> map)
    {
        return ttUserDao.queryTotal(map);
    }

    @Override
    public TtUser selectUserByUserName(String userName) {
        return ttUserDao.selectUserByUserName(userName);
    }
}
