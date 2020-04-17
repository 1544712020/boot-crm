package com.lwz.core.service;

import com.lwz.core.po.User;

/**
 * 用户Service层接口
 */

public interface UserService {

    // 通过账号和密码查询用户
    public User findUser(String usercode, String password);

}
