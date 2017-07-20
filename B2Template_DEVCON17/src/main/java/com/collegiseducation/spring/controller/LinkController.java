package com.collegiseducation.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinkController {

	private static final ch.qos.logback.classic.Logger LOGGER = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(LinkController.class);
		
	@RequestMapping(value = { "course_tool" }, method = RequestMethod.GET)
	public String getCourseTool(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "course_tool";

	}

	@RequestMapping(value = { "system_tool" }, method = RequestMethod.GET)
	public String getSystemTool(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "system_tool";
	}

	@RequestMapping(value = { "tool" }, method = RequestMethod.GET)
	public String getTool(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "tool";

	}
}
