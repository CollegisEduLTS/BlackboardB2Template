package com.collegiseducation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

import blackboard.data.ReceiptOptions;
import blackboard.platform.plugin.PlugInException;
import blackboard.platform.plugin.PlugInUtil;
import blackboard.platform.servlet.InlineReceiptUtil;
import ch.qos.logback.classic.Level;

public class Settings {

	private static final ch.qos.logback.classic.Logger LOGGER = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(Settings.class);

	private ReceiptOptions ro = null;
	private String vendor;
	private String handle;

	public Settings(HttpServletRequest request) {
		this.ro = InlineReceiptUtil.getReceiptFromRequest(request);
		if (null == ro) {
			this.ro = new ReceiptOptions();
		}

		String[] vendorAndHandle = this.getVendorAndHandle();
		this.vendor = vendorAndHandle[0];
		this.handle = vendorAndHandle[1];
	}

	public Properties getSettingsFromFile() {
		Properties props = new Properties();
		InputStream input = null;
		try {
			File myConfigDir = PlugInUtil.getConfigDirectory(this.vendor, this.handle);
			File myConfigFile = new File(myConfigDir, handle + ".properties");

			input = new FileInputStream(myConfigFile);
			props.load(input);
		} catch (PlugInException e) {
			LOGGER.error("An error occurred loading the config file: " + e.getLocalizedMessage(), e);
			this.ro.addErrorMessage(
					"An error occurred loading the settings.  Please contact the Personal Support Center if this issue persists.",
					e);
		} catch (FileNotFoundException e) {
			LOGGER.error("A config file was not found! " + e.getLocalizedMessage(), e);
			this.ro.addErrorMessage("No settings file was found.  Please update the settings and try again.", e);
		} catch (IOException e) {
			LOGGER.error("An error occurred reading the properties file: " + e.getLocalizedMessage(), e);
			this.ro.addErrorMessage(
					"An error occurred loading the settings.  Please contact the Personal Support Center if this issue persists.",
					e);
		}

		return props;
	}

	public Level getLogLevel() {
		Properties props = this.getSettingsFromFile();
		String strLevel = props.getProperty("logLevel");

		// Using WARN as the default
		Level logLevel = Level.WARN;
		switch (strLevel.toUpperCase()) {
			case "TRACE":
				logLevel = Level.TRACE;
				break;
			case "DEBUG":
				logLevel = Level.DEBUG;
				break;
			case "INFO":
				logLevel = Level.INFO;
				break;
			case "WARN":
				logLevel = Level.WARN;
				break;
			case "ERROR":
				logLevel = Level.ERROR;
				break;
			default:
				logLevel = Level.WARN;
				break;
		}
		return logLevel;
	}

	public Properties setSettingsFromFile(Map<String, String[]> settingsMap) {
		Properties props = new Properties();
		OutputStream output = null;

		try {
			File myConfigDir = PlugInUtil.getConfigDirectory(this.vendor, this.handle);
			File myConfigFile = new File(myConfigDir, handle + ".properties");

			output = new FileOutputStream(myConfigFile);

			for (Map.Entry<String, String[]> entry : settingsMap.entrySet()) {
				String key = entry.getKey();
				String value = String.join(",", entry.getValue());
				props.setProperty(key, value);
			}

			props.store(output, null);
			ro.addSuccessMessage("The settings were updated successfully.");
		} catch (PlugInException e) {
			LOGGER.error("An error occurred loading the config file: " + e.getLocalizedMessage(), e);
			this.ro.addErrorMessage(
					"An error occurred saving the settings.  Please contact the Personal Support Center if this issue persists.",
					e);
		} catch (FileNotFoundException e) {
			LOGGER.error("A config file was not found! " + e.getLocalizedMessage(), e);
			this.ro.addErrorMessage(
					"An error occurred saving the settings.  Please contact the Personal Support Center if this issue persists.",
					e);
		} catch (IOException e) {
			LOGGER.error("An I/O exception occurred writing the output file: " + e.getLocalizedMessage(), e);
			this.ro.addErrorMessage(
					"An error occurred saving the settings.  Please contact the Personal Support Center if this issue persists.",
					e);
		}

		return getSettingsFromFile();
	}

	private String[] getVendorAndHandle() {
		String[] vendorAndHandle = null;
		String location = this.getClass().getClassLoader()
				.getResource(this.getClass().getName().replace('.', '/') + ".class").toString();
		int pos = location.indexOf("/plugins/");
		if (pos >= 0) {
			vendorAndHandle = new String[2];

			location = location.substring(pos + 9);
			location = location.substring(0, location.indexOf('/'));
			String[] plugInElements = location.split("-", 2);
			String vendorId = plugInElements[0];
			String handle = plugInElements[1];
			vendorAndHandle[0] = vendorId;
			vendorAndHandle[1] = handle;
		}

		return vendorAndHandle;
	}
}
