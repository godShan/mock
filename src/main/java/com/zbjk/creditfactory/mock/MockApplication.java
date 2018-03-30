package com.zbjk.creditfactory.mock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 *@author wys
 *@date 2018/02/23
 *@description
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.zbjk.creditfactory.mock.mapper")
public class MockApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的MsmApplication启动类
		return builder.sources(MockApplication.class);
	}
}
