package com.xrh.xrh_application.interceptor;

import org.springframework.web.servlet.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class LoginInterceptor implements HandlerInterceptor {
 
    @Override
    public boolean preHandle(@SuppressWarnings("null") HttpServletRequest request, @SuppressWarnings("null")  HttpServletResponse
            response, @SuppressWarnings("null") Object handler) throws Exception {
        
        
        System.out.println("prehandle");
        System.out.println(request.getContentType());
        return true;
    }
    



}