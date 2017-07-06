package com.collegiseducation.spring.controller;

import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collegiseducation.util.Settings;

@Controller
@RequestMapping("/admin")
public class SettingsController {
	
	private static final ch.qos.logback.classic.Logger LOGGER = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(SettingsController.class);

	@RequestMapping(value = { "module_settings" }, method = RequestMethod.GET)
	public String getSettingsPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "module_settings";
	}

	@RequestMapping(value = { "module_settings" }, method = RequestMethod.POST)
	public String setSettings(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "module_settings";
	}

	@RequestMapping(value = { "admin_settings" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String getAdminSettingsPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Settings _s = new Settings(request);

		LOGGER.setLevel(_s.getLogLevel());
				
		if (request.getMethod().equalsIgnoreCase("POST")) {
			@SuppressWarnings("unchecked")
			Map<String, String[]> settings = request.getParameterMap();
			Properties props = _s.setSettingsFromFile(settings);
			model.addAttribute("settings", props);
			return "admin_settings";
		} else {
			Properties props = _s.getSettingsFromFile();
			model.addAttribute("settings", props);
			return "admin_settings";
		}
	}
}
