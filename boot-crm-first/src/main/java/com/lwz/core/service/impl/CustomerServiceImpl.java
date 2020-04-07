package com.lwz.core.service.impl;

import com.lwz.core.dao.CustomerDao;
import com.lwz.core.po.Customer;
import com.lwz.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //注解注入CustomerDao
    @Autowired
    private CustomerDao customerDao;
    //查询客户
    public Customer findCustomerById(Integer id) {

        return this.customerDao.findCustomerById(id);
    }
}
