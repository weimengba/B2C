package com.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 解决Tomcat Reload的内存溢出问题.
 * 
 * @author Administrator
 * 
 */
public class TomcatMemListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Switch to system classloader in before we load/call some JRE stuff
		// that will cause
		// the current classloader to be available for garbage collection
		Thread.currentThread().setContextClassLoader(
				ClassLoader.getSystemClassLoader());
		try {
			// Will start a Thread
			java.awt.Toolkit.getDefaultToolkit();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		java.security.Security.getProviders();
		// Load initial drivers using system classloader
		java.sql.DriverManager.getDrivers();
		// Will call sun.awt.AppContext.getAppContext()
		javax.imageio.ImageIO.getCacheDirectory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
