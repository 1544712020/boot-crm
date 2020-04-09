package com.lwz.core.web.controller;

import com.lwz.common.utils.Page;
import com.lwz.core.po.BaseDict;
import com.lwz.core.po.Customer;
import com.lwz.core.service.BaseDictService;
import com.lwz.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    /*依赖注入*/
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;

    /*使用@Value来调用resource中的值赋值给属性*/
    /*客户来源*/
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    /*客户所属行业*/
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    /*客户级别*/
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    /*客户列表*/
    @RequestMapping(value = "/customer/list.action")
    /*@RequestParam使用defaultValue属性设置默认值
    注意设置必须是string类型的，框架自己会做转换*/
    public String list(@RequestParam(defaultValue = "1")Integer page,
                                @RequestParam(defaultValue = "10")Integer rows,
                                String custName, String custSource, String custIndustry, String custLevel, Model model) {
        /*查询所有客户*/
        Page<Customer> customers = customerService
                .findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
        /*客户来源*/
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        /*客户来源*/
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        /*客户来源*/
        List<BaseDict> levelType = baseDictService
                .findBaseDictByTypeCode(LEVEL_TYPE);
        /*为model添加参数*/
        model.addAttribute("page", customers);
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "customer";
    }

}
