package com.ly.provider.sys.Service;


import com.ly.provider.sys.entity.City;

public interface CityService {


    City findCityByName(String cityName);
}
