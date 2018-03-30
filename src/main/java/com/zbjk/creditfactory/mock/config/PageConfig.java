package com.zbjk.creditfactory.mock.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 *@author wys
 *@date 2018/03/20
 *@description
 */
@Configuration
public class PageConfig {

    @Bean
    public PageHelper pageHelper(){

        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum","true");
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");
        p.setProperty("pageSizeZero","true");
        pageHelper.setProperties(p);

        return pageHelper;

    }

}

