/**
 * 
 */
package com.cucumber.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author p.x.chopra
 *
 */
public class Log {

	public static Logger log;
	private static String fileName = "Log";
	private static final String logPropertiestFilePath = "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator
			+ "configs" + File.separator + "log4j.properties";

	static {
		try {
			fileName = fileName + "-" + TimeUtils.getInstance().getTimeString()
					+ ".log";
			fileName = System.getProperty("user.dir") + File.separator
					+ "target" + File.separator + fileName;
			File file = new File(fileName);
			if (file.createNewFile()) {
				Properties props = new Properties();
				props.load(new FileInputStream(logPropertiestFilePath));
				props.setProperty("log4j.appender.file.File", fileName);
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.print("IO Exception in static method of Logger Class. "
					+ ex.getMessage());
			System.exit(-1);
		}
	}

	/**
	 * @param clazz
	 * @return
	 */
	public static Logger getLogger(@SuppressWarnings("rawtypes") Class clazz) {
		if (log == null) {
			log = LogManager.getLogger(clazz);
			return log;
		} else
			return log;
	}
}
