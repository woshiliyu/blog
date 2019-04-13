package com.ly.provider.sys.Service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ly.common.utils.rest.PageUtils;
import com.ly.common.utils.Query;

import com.ly.provider.sys.dao.HouseDao;
import com.ly.provider.sys.entity.House;
import com.ly.provider.sys.Service.HouseService;


@Service("houseService")
public class HouseServiceImpl  implements HouseService {

    @Autowired
    private HouseDao houseDao;
    @Override
    public List<House> queryList(Map<String, Object> map) {
        return houseDao.queryList(map);
    }

    @Override
    public House selectById(Integer houseId)
    {
        return houseDao.selectById(houseId);
    }


    @Override
    public int insertHouse(House house)
    {
        return houseDao.insertHouse(house);
    }

    @Override
    public int updateHouse(House house)
    {
        return houseDao.updateHouse(house);
    }

    @Override
    public int deleteHouseByIds(String ids)
    {
        return houseDao.deleteHouseByIds(ids);
    }

    @Override
    public int queryTotal(Map<String, Object> map)
    {
        return houseDao.queryTotal(map);
    }
}
