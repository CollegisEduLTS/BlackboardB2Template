package com.collegiseducation.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModuleController {

	private static final ch.qos.logback.classic.Logger LOGGER = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(ModuleController.class);

	// presents the primary module page
	// Intercepts both GET and POST requests, to cover for async loaded modules
	@RequestMapping(value = { "module" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String getRequest(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "module";

	}
}
