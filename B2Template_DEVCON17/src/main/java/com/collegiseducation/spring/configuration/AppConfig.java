package com.collegiseducation.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

// This configuration is for the model layer
@Configuration
@ComponentScan(basePackages = "com.collegiseducation", excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.collegiseducation.spring.controller.*"))
@EnableScheduling
@PropertySource(value = { "classpath:config.properties" }, ignoreResourceNotFound = true)
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
