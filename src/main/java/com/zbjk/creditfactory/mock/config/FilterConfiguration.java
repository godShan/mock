package com.zbjk.creditfactory.mock.config;

import com.zbjk.creditfactory.mock.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/13/013.
 * @author weiyushan
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterDemo4Registration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new LoginFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(false);
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }
}
