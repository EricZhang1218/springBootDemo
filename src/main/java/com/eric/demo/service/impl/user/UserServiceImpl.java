package com.eric.demo.service.impl.user;

import com.eric.demo.db.search.UserSearch;
import com.eric.demo.db.user.User;
import com.eric.demo.mapper.user.UserMapper;
import com.eric.demo.service.user.UserService;
import com.eric.demo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public Page pageQuery(UserSearch search) {
        Page page = new Page(search.getPageNo() , search.getPageSize(), userMapper.count(search));
        search.setBegin(page.getBegin());
        search.setPageSize(page.getPageSize());
        page.setData(userMapper.pageQuery(search));
        return page;
    }
}
