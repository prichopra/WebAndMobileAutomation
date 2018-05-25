package framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.utils.Log;


public class BasePage extends LoadableComponent {
	Logger log = Log.getLogger(BasePage.class);

	protected final int MAX_WAIT = 3000;

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param webElement
	 * @param textToType
	 */
	protected void type(WebDriver driver,WebElement webElement, String textToType) {
		waitForElement(driver,webElement);
//		webElement.clear();
		webElement.click();
		webElement.sendKeys(textToType);
	}

	/**
	 * @param driver
	 * @param xPath
	 * @return
	 */
	protected WebElement findByXPath(WebDriver driver, String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * @param driver
	 * @param element
	 * @param maxWait
	 */
	protected void click(WebDriver driver, WebElement element) {
		waitForElement(driver, element);
		log.info("tapping on "+element.getAttribute("name"));
		element.click();
	}

	/**
	 * @param driver
	 * @param element
	 * @param maxWait
	 * @return
	 */
	protected boolean waitForElement(WebDriver driver, WebElement element) {
		boolean statusOfElementToBeReturned = false;
		long startTime = new java.util.Date().getTime();
		WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
		try {
			Thread.sleep(2000);
			WebElement waitElement = wait.until(ExpectedConditions
					.elementToBeClickable(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfElementToBeReturned = true;
				log.info("Element is displayed:: " + element.toString());
			}
		} catch (Exception e) {
			statusOfElementToBeReturned = false;
			log.info("Unable to find a element after "
					+ (new java.util.Date().getTime() - startTime)
					+ " milli sec ==> " + element.toString());
		}
		log.info("statusOfElementToBeReturned " + statusOfElementToBeReturned);
		return statusOfElementToBeReturned;
	}

	/**
	 * @param driver
	 * @param xpath
	 * @param maxWait
	 * @return
	 */
	protected boolean waitForElement(WebDriver driver, String xpath) {
		boolean statusOfElementToBeReturned = false;
		long startTime = new java.util.Date().getTime();
		WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);
		try {
			Thread.sleep(2000);
			WebElement waitElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(xpath))));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfElementToBeReturned = true;
				log.info("Element is displayed:: ");
			}
		} catch (Exception e) {
			statusOfElementToBeReturned = false;
			log.info("Unable to find a element after "
					+ (new java.util.Date().getTime() - startTime)
					+ " milli sec ==> ");
		}
		return statusOfElementToBeReturned;
	}

	/**
	 * @param driver
	 * @param xPath
	 * @param maxWait
	 * @return
	 */
	protected WebElement findByXPath(WebDriver driver, String xPath, int maxWait) {
		waitForElement(driver, xPath);
		WebElement element = driver.findElement(By.xpath(xPath));
		return element;
	}

	/**
	 * @param driver
	 * @param linkText
	 * @param maxWait
	 * @return
	 */
	protected WebElement findByLinkText(WebDriver driver, String linkText,
			int maxWait) {

		@SuppressWarnings("unused")
		boolean statusOfElementToBeReturned = false;
		long startTime = new java.util.Date().getTime();
		WebDriverWait wait = new WebDriverWait(driver, maxWait);
		try {
			WebElement waitElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(linkText))));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfElementToBeReturned = true;
				log.info("Element is displayed:: "
						+ driver.findElement(By.linkText(linkText)).toString());
			}
		} catch (Exception e) {
			statusOfElementToBeReturned = false;
			log.info("Unable to find a element after "
					+ (new java.util.Date().getTime() - startTime)
					+ " milli sec ==> "
					+ driver.findElement(By.linkText(linkText)).toString());
		}
		WebElement element = driver.findElement(By.linkText(linkText));
		return element;
	}

	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	protected String getText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	/**
	 * @param elementFrom
	 * @param elementTo
	 */
	protected void swipeVerticalFromElementToElement(WebElement elementFrom,
			WebElement elementTo) {

	}

}