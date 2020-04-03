package com.yeyun.config;


import com.yeyun.interceptor.AccessLogInterceptor;
import com.yeyun.interceptor.CustomHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web访问配置
 *
 * @author CZH
 */
@Configuration
public class WebXmlConfig implements WebMvcConfigurer {

    private static String[] loginUrls = {"/login/loginout","/common/Author/AuthRole_UpdateOnly","/common/Author/ChangePwd"};
    private static String[] operationUrls = {"/common/**","/leader/**","/operations/**","/salesman/**","/staff/**","/supervisor/**","/supervisor/**"};
    private final String[] excludePath = {"/static"};
    /**
     * 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCustomHandlerInterceptor()).addPathPatterns(loginUrls).addPathPatterns(operationUrls);
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
//        registry.addInterceptor(getOperationRequestInterceptor()).addPathPatterns(operationUrls).excludePathPatterns(loginUrls);
//        registry.addInterceptor(getRequestInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public CustomHandlerInterceptor getCustomHandlerInterceptor(){
        return new CustomHandlerInterceptor();
    }

//    @Bean
//    public OperationRequestInterceptor getOperationRequestInterceptor(){
//        return new OperationRequestInterceptor();
//    }
//
//    @Bean
//    public RequestInterceptor getRequestInterceptor(){
//        return new RequestInterceptor();
//    }
}
