package com.lwz.core.interceptor;

import com.lwz.core.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {

    /*先执行过滤器中的此方法，若返回true在执行controller中的方法*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*获取URL*/
        String url = request.getRequestURI();
        /*除了登录请求之外其他的URL全部拦截*/
        if (url.indexOf("/login.action") >= 0) {
            return true;
        }
        /*获取session*/
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        /*判断Session中是否有用户数据，如果有，则返回true，继续往下执行*/
        if (user != null) {
            return true;
        }
        /*不符合条件的给出提示信息，并转发到登录页面*/
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
