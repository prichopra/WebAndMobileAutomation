package com.cucumber.stepdefinitions;

import com.cucumber.utils.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import static framework.Holder.driver;

/**
 * @author p.x.chopra
 *
 */
public class GlobalHooks {

	Logger log = Log.getLogger(GlobalHooks.class);

	/**
	 * @param scenario
	 * @throws IOException
	 */
	@Before
	public void setupScript(final Scenario scenario) throws IOException {
		log.info("-------------------------------------------------------------------------------------------------------------");
		log.info("Running scenario " + scenario.getName());
		log.info("Initiating driver object");
		driver = new DriverFactory().getDriver();
	}

	/**
	 * @param scenario
	 */
	@After
	public void teardownScript(final Scenario scenario) {
		try {
			// if (scenario.isFailed()) {
			log.info(scenario.getName() + " is failed");
			log.info(" Adding screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			// }
		} finally {
			log.info("Killing driver object");
			log.info("Completed scenario " + scenario.getName());
			log.info("-------------------------------------------------------------------------------------------------------------");
			if (driver != null)
				driver.quit();
		}
	}
}
