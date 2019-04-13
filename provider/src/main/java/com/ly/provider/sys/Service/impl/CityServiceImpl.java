package com.ly.provider.sys.Service.impl;



import com.ly.provider.sys.Service.CityService;
import com.ly.provider.sys.dao.CityDao;

import com.ly.provider.sys.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {

        return cityDao.findByName(cityName);
    }
}
