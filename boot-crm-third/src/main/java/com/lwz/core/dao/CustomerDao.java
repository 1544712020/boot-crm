package com.lwz.core.dao;

import com.lwz.core.po.Customer;

import java.util.List;

/**
 * Customer的Dao接口
 */

public interface CustomerDao {

    /*客户列表*/
    public List<Customer> selectCustomerList(Customer customer);
    /*客户数*/
    public Integer selectCustomerListCount(Customer customer);

}