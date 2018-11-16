package com.eric.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create By Eric on 2018/10/25
 * spring boot 分页
 */
@Mapper
public interface BaseMapper<T> {
    public Integer count(T search);

    public List<?> pageQuery(T search);
}
