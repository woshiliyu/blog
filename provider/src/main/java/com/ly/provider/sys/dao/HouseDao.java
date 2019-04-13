package com.ly.provider.sys.dao;

import com.ly.provider.sys.entity.House;
import java.util.Map;
import java.util.List;



/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-25 16:14:01
 */
public interface HouseDao  {
    List<House> queryList(Map<String, Object> map);

    public House selectById(Integer houseId);

    public int insertHouse(House house);

    public int updateHouse(House house);

    public int deleteHouseByIds(String ids);

    int queryTotal(Map<String, Object> map);
}
