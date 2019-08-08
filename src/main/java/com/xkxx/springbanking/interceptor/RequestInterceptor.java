package com.xkxx.springbanking.interceptor;

import com.xkxx.springbanking.entity.Customer;
import com.xkxx.springbanking.model.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestInterceptor implements HandlerInterceptor {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();
        String curOrigin = request.getHeader("Origin");
        log.debug("当前访问来源是：" + curOrigin + "----请求路径："
                + uri + ",servletPath=" + servletPath
                + ",queryString=" + queryString);

        HttpSession session = request.getSession();

        String openid = (String) session.getAttribute("openid");
        Customer customer = (Customer) session.getAttribute("customer");
        if (handler instanceof HandlerMethod) {
            if (servletPath.startsWith("/test")) {
                return true;
            }
//            else {
//                response.sendRedirect(uri + request.getContextPath() + "/errPage?retMsg=" + ErrorType.NO_PEMISSION_ERROR.getErrMsg());
//                return false;
//            }
            if (customer == null){
                log.debug("用户未登陆");
                response.sendRedirect("login");
                return false;
            }else {
                log.debug("用户已登陆");
                return true;
            }
        } else {
            //静态文件
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
