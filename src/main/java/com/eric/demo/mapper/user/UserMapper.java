package com.eric.demo.mapper.user;

import com.eric.demo.db.search.UserSearch;
import com.eric.demo.db.user.User;
import com.eric.demo.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserSearch>{
    User findAll();

    User findByName(String name);
}
