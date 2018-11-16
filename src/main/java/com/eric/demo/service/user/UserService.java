package com.eric.demo.service.user;

import com.eric.demo.db.search.UserSearch;
import com.eric.demo.db.user.User;
import com.eric.demo.utils.Page;

public interface UserService {
    User findAll();

    User findByName(String name);

    Page pageQuery(UserSearch search);
}
