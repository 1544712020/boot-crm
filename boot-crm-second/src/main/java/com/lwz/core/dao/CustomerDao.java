package com.lwz.core.dao;

import com.lwz.core.po.Customer;

/**
 * DAO层（数据访问层）
 */

public interface CustomerDao {

    // 通过id查询用户
    public Customer findCustomerById(Integer id);

}
