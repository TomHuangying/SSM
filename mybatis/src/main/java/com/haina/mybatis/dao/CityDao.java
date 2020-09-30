package com.haina.mybatis.dao;

import com.haina.mybatis.model.City;

public interface CityDao {
//  获取得城市信息要包含国家

    /**
     * 采用两个表联合查询得方式，直接查询出两个表的数据，分别放入对应得对象中
     * @param id
     * @return
     */
    City getCityById1(int id);

    /**
     * 分别查询两个表的数据,然后两个表查询出来数据分别放入各自对应得对象中
     */
    City getCityById2(int id);
}
