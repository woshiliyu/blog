package com.ly.provider.sys.Service;


import com.ly.common.utils.rest.PageUtils;
import com.ly.provider.sys.entity.House;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-25 16:14:01
 */
public interface HouseService {

    public List<House>  queryList(Map<String, Object> map);

    public House selectById(Integer houseId);

    public int insertHouse(House house);

    public int updateHouse(House house);

    public int deleteHouseByIds(String ids);

    int queryTotal(Map<String, Object> map);
}

