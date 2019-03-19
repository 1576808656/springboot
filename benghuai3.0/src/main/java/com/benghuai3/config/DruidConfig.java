//package com.benghuai3.config;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
///**
// * Druid数据源的配置类
// * @author zyh
// *
// */
//@Configuration
//public class DruidConfig {
//
//	@ConfigurationProperties(prefix="spring.datasource")
//	@Bean
//	public DataSource druid() {
//		return new DruidDataSource();
//	}
//	
//	//配置Druid的监控
//	//配置一个管理后台的Servlet
//	@Bean
//	public ServletRegistrationBean statViewServlet() {
//		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//		Map<String,String>initParams = new HashMap<>();		//设置初始化参数
//		initParams.put("loginUsername", "admin");	//后台登录账号
//		initParams.put("loginPassword", "admin");	//后台登录密码
//		initParams.put("allow", "localhost");	//允许谁访问，默认所有人都可以访问
//		initParams.put("deny", "192.168.43.21");	//拒绝谁来访问
//		bean.setInitParameters(initParams);
//		return bean;
//	}
//	
//	//配置一个filter
//	@Bean
//	public FilterRegistrationBean webStatFilter() {
//		FilterRegistrationBean bean = new FilterRegistrationBean();
//		bean.setFilter(new WebStatFilter());
//		Map<String,String>initParams = new HashMap<>();
//		initParams.put("exclusions", "*.js,*.css,/druid/*,,*.png");	//哪些请求不用拦截
//		bean.setInitParameters(initParams);
//		bean.setUrlPatterns(Arrays.asList("/*"));
//		return bean;
//	}
//}
