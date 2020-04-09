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

}
