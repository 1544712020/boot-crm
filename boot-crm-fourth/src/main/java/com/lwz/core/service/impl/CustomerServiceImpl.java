package com.lwz.core.service.impl;

import com.lwz.common.utils.Page;
import com.lwz.core.dao.CustomerDao;
import com.lwz.core.po.Customer;
import com.lwz.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //注解注入CustomerDao
    @Autowired
    private CustomerDao customerDao;

    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel) {
        /*创建客户对象*/
        Customer customer = new Customer();
        /*判断客户名称是否为空*/
        if (StringUtils.isNotBlank(custName)) {
            customer.setCust_name(custName);
        }
        /*判断客户来源信息是否为空*/
        if (StringUtils.isNotBlank(custSource)) {
            customer.setCust_source(custSource);
        }
        /*判断客户行业是否为空*/
        if (StringUtils.isNotBlank(custIndustry)) {
            customer.setCust_source(custIndustry);
        }
        /*判断客户等级是否为空*/
        if (StringUtils.isNotBlank(custLevel)) {
            customer.setCust_source(custLevel);
        }
        /*当前页*/
        customer.setStart((page -1 ) * rows);
        /*每页显示客户数量*/
        customer.setRows(rows);
        /*查询客户列表*/
        List<Customer> customers = customerDao.selectCustomerList(customer);
        /*查询客户列表总记录数*/
        Integer count = customerDao.selectCustomerListCount(customer);

        /*创建page返回对象*/
        Page<Customer> result = new Page<>();
        result.setPage(page); // 当前页
        result.setRows(customers); // 结果集
        result.setSize(rows); // 每页数
        result.setTotal(count); // 总条数
        return result;
    }

    /*添加用户*/
    @Override
    public int createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    /*通过id查询客户*/
    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    /*更新用户数据*/
    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    /*删除用户*/

    @Override
    public int deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }
}
