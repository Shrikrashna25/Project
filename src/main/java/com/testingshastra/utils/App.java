package com.testingshastra.utils;

public class App {
	static String filePath = System.getProperty("user.dir")+"/src/main/resources/Config/app.properties";

	static final PropUtils prop = new PropUtils();
	
	public static String getBrowserName() {
		return prop.getProperty(filePath, "browser_name");
	}
	
	public static String getAppUrl(String env) {
		return prop.getProperty(filePath, env+"_app_url");
	}
	
	public static boolean isOnGrid() {
		return Boolean.parseBoolean(prop.getProperty(filePath, "isOnGrid"));
	}
}
