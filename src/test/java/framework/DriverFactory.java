
package framework;

import com.cucumber.utils.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import static framework.Holder.EMPTY_STRING;


public class DriverFactory {

	static String driverHost;
	static String driverPort;
	static String platform;
	static String hubUrl;
	private DesiredCapabilities capabilities;
	public static RemoteWebDriver driver;
	Logger log = Log.getLogger(DriverFactory.class);

	static {
		platform = System.getProperty("platform") != null ? System
				.getProperty("platform") : "chrome";
		driverHost = System.getProperty("driverHost") != null ? System
				.getProperty("driverHost") : "127.0.0.1";
		driverPort = System.getProperty("driverPort") != null ? System
				.getProperty("driverPort") : "12345";
		hubUrl = "http://" + driverHost + ":" + driverPort + "/wd/hub";
	}

	/**
	 * @return
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("static-access")
	public RemoteWebDriver getDriver() throws MalformedURLException {
		switch (platform.toLowerCase()) {
			case "android":
				capabilities = new DesiredCapabilities().android();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						Platform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						"7.0");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"0215313745333838");
				//capabilities.setCapability(MobileCapabilityType.UDID,"6S6LEUQS857HL7U4");
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
				capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,
						true);
				capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS,
						true);

				capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\p.x.chopra\\Desktop\\Check this\\CucumberExtentReporter-master\\com.buuuk.st_2018-05-16.apk");
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
						EMPTY_STRING);
				capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE,"com.buuuk.st");
				//capabilities.setCapability("appPackage", "com.buuuk.st");
				capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,
						"com.sph.straitstimes.views.activities.TncActivity");

				capabilities.setCapability("waitForAppScript","$.delay(100); true;");
				driver = new AppiumDriver<>(new URL("http://127.0.0.1:12345/wd/hub"),capabilities);


				log.info("Android driver has been returned");
				break;
			case "androidWeb":
				capabilities = new DesiredCapabilities().android();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						Platform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						"6.0");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
						"Lenovo Vibe K4 Note");
				capabilities.setCapability(MobileCapabilityType.UDID,
						"6S6LEUQS857HL7U4");
				capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,
						true);
				capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS,
						true);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
						BrowserType.CHROME);
				driver = new AndroidDriver<>(new URL(hubUrl), capabilities);
				log.info("Android driver has been returned");
				break;
			case "ios":
				capabilities = new DesiredCapabilities().iphone();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						"iOS");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						"9.3.5");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
						"iPhone 5s");
				// capabilities.setCapability(MobileCapabilityType.UDID,
				// "bef9ff04c92a61f0690c605c82d8ec432d83b57a");
				capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
				// capabilities.setCapability(MobileCapabilityType.FULL_RESET,
				// false);
				capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,
						true);
				capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS,
						true);
				// capabilities.setCapability(MobileCapabilityType.APP,
				// "com.sc.BreezeMy.testing");
				// capabilities.setCapability("bundleId",
				// "com.sc.BreezeMy.testing");
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
						EMPTY_STRING);
				driver = new IOSDriver<MobileElement>(new URL(hubUrl), capabilities);
				log.info("IOS driver has been returned");
				break;
			case "iosWeb":
				capabilities = new DesiredCapabilities().iphone();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						"iOS");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
						"9.3.5");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
						"iPhone 5s");
				// capabilities.setCapability(MobileCapabilityType.UDID,
				// "bef9ff04c92a61f0690c605c82d8ec432d83b57a");
				capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,
						true);
				capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS,
						true);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
						BrowserType.SAFARI);
				driver = new IOSDriver<MobileElement>(new URL(hubUrl), capabilities);
				log.info("IOS driver has been returned");
				break;
			case "chrome":
				capabilities = new DesiredCapabilities().chrome();
				capabilities.setPlatform(Platform.WINDOWS);
				//capabilities.setCapability("platformName","WINDOWS");
				//capabilities.setCapability("deviceName","WINDOWSPC");
				System.setProperty("webdriver.chrome.driver", "C:/Users/p.x.chopra/Desktop/Check this/CucumberExtentReporter-master/chromedriver_win32/chromedriver.exe");
				capabilities.setCapability("webdriver.chrome.args", Arrays.asList("--whitelisted-ips=10.17.200.56"));
				//capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--disable-web-security");
				chromeOptions.addArguments("--test-type");
				capabilities.setCapability("chrome.verbose", false);
				//capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				driver =  new ChromeDriver(capabilities);
				log.info("Chrome driver has been returned");
				break;
			default:
				capabilities = new DesiredCapabilities().android();
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"0215313745333838");
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
				capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,
						true);
				capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS,
						true);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
						EMPTY_STRING);
				capabilities.setCapability("appPackage", "com.google.android.straitstimes");
				driver = new RemoteWebDriver(new URL(hubUrl),capabilities);
				log.info("Driver has been defaulted to Android");
				break;
		}
		return driver;
	}
}

