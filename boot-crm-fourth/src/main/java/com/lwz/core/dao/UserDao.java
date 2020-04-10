package com.lwz.core.dao;

import com.lwz.core.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Dao层接口
 */

public interface UserDao {

    /**
     * 通过账号和密码查询用户
     */
    public User findUser(
            // @Param("username")表示为参数命名，在映射文件中使用#{usercode}就可以获取usercode的值
            @Param("usercode") String usercode,
            @Param("password") String password
    );

}
