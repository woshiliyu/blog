package com.ly.provider.sys.dao;

import com.ly.provider.sys.entity.City;
import org.apache.ibatis.annotations.Param;




public interface CityDao {

    City findByName(@Param("cityName") String cityName);
}
