package com.collegiseducation.spring.configuration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.LocaleResolver;

import blackboard.platform.intl.LocaleManagerFactory;

public class LocaleInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
    throws Exception {
		
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request,response,LocaleManagerFactory.getInstance().getLocale().getLocaleObject());
		
		return true;
    }
}
