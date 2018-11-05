package org.calendar.jan.config;

import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 配置druid监控
 * @author xman
 *
 */
@Configuration
public class DruidConfig {

	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new StatViewServlet());
		// 此处必须配置为/druid/* <待研究>
		srb.setUrlMappings(Collections.singletonList("/druid/*"));
		// 设置IP地址白名单
		srb.addInitParameter("allow", "127.0.0.1,192.168.0.165");
		// 设置黑名单
		srb.addInitParameter("deny", "");
		// 用户
		srb.addInitParameter("loginUsername", "admin");
		srb.addInitParameter("loginPassword", "1");
		// 是否可以重置数据
		srb.addInitParameter("resetEnable", "false");
		return srb;
	}
	
	@Bean
	public FilterRegistrationBean statFilter() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new WebStatFilter());
		frb.setUrlPatterns(Collections.singletonList("/*"));
		frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return frb;
	}
	
}
