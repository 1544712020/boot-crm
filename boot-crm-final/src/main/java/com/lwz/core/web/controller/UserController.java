package com.lwz.core.web.controller;

import com.lwz.core.po.User;
import com.lwz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器类
 */

@Controller
public class UserController {

    // 依赖注入
    @Autowired
    private UserService userService;
    // 用户登录
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session) {

        // 通过账号和密码查询用户
        User user = userService.findUser(usercode, password);
        if (user != null) {
            // 将用户添加到session中
            session.setAttribute("USER_SESSION", user);
            // 跳转到主页面
            return "redirect:customer/list.action";
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        return "login";
    }

    // 退出登录
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
        /*清除session*/
        session.invalidate();
        /*重定向到登录页面的跳转方法*/
        return "redirect:login.action";
    }
    // 点击退出登录后向用户登录页面跳转
    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

}
