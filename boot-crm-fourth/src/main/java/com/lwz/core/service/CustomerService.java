package com.lwz.core.service;

/**
 * 客户Service接口
 */

import com.lwz.common.utils.Page;
import com.lwz.core.po.Customer;

public interface CustomerService {

	// 根据客户的名称、来源、所属行业、客户级别来检索客户
	public Page<Customer>  findCustomerList(
			Integer page, Integer rows,
			String custName, String custSource,
			String custIndustry, String custLevel);

	/*添加客户对象*/
    public int createCustomer(Customer customer);

    /*通过id查询客户*/
	public Customer getCustomerById(Integer id);

	/*更新客户*/
	public int updateCustomer(Customer customer);

	/*删除用户*/
	public int deleteCustomer(Integer id);
}
