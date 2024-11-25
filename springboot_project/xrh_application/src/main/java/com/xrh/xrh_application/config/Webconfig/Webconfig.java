package com.xrh.xrh_application.config.Webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xrh.xrh_application.interceptor.LoginInterceptor;



@Configuration  
public class Webconfig implements WebMvcConfigurer {  
  
    //⾃定义的拦截器对象
   
    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        //注册⾃定义拦截器对象
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许的前端源
                .allowedMethods("*") // 允许的HTTP方法
                .allowedHeaders("*") // 允许的HTTP头部
                .allowCredentials(false); // 是否允许携带认证信息（如Cookies）
    }

}
