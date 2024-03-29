package com.lwz.core.service.impl;

import com.lwz.core.dao.UserDao;
import com.lwz.core.po.User;
import com.lwz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service层接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    // 注入UserDao
    @Autowired
    private UserDao userDao;

    // 通过账号和密码查询用户
    public User findUser(String usercode, String password) {
        User user = this.userDao.findUser(usercode, password);
        return user;
    }
}
