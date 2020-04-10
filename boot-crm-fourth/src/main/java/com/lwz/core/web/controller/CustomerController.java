package com.lwz.core.web.controller;

import com.lwz.common.utils.Page;
import com.lwz.core.po.BaseDict;
import com.lwz.core.po.Customer;
import com.lwz.core.po.User;
import com.lwz.core.service.BaseDictService;
import com.lwz.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 客户管理控制器类
 */
@Controller
public class CustomerController {
    // 依赖注入
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;
    // 客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    // 客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    // 客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;
    /**
     *  客户列表
     */
    @RequestMapping(value = "/customer/list.action")
    public String list(@RequestParam(defaultValue="1")Integer page,
                       @RequestParam(defaultValue="10")Integer rows,
                       String custName, String custSource, String custIndustry,
                       String custLevel, Model model) {
        // 条件查询所有客户
        Page<Customer> customers = customerService
                .findCustomerList(page, rows, custName,
                        custSource, custIndustry,custLevel);
        model.addAttribute("page", customers);
        // 客户来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        // 客户所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        // 客户级别
        List<BaseDict> levelType = baseDictService
                .findBaseDictByTypeCode(LEVEL_TYPE);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "customer";
        }

    /**
     * 创建客户
     */
    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session) {
        /*获取当前Session里面的用户信息*/
        User user = (User) session.getAttribute("USER_SESSION");
        /*将当前用户id存储在客户对象中的客户创建id中*/
        customer.setCust_create_id(user.getUser_id());
        /*创建Date对象*/
        Date date = new Date();
        /*获取一个TimeStamp格式的时间，用于存入相关的时间至数据库*/
        Timestamp timestamp = new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);
        /*执行service中的创建方法*/
        int rows = customerService.createCustomer(customer);
        System.out.println(rows);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    /*通过id查询客户信息*/
    @RequestMapping("/customer/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    /*更新客户*/
    @RequestMapping("/customer/update.action")
    @ResponseBody
    public String customerUpdate(Customer customer) {
        int rows = customerService.updateCustomer(customer);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    /*删除用户*/
    @RequestMapping("/customer/delete.action")
    @ResponseBody
    public String customerDelete(Integer id) {
        int rows = customerService.deleteCustomer(id);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

}
