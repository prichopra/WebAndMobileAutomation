package pages;

import Common.PropLocation;
import Common.ReadPropertiesValues;
import framework.DriverFactory;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.HashMap;

import static java.time.Duration.ofSeconds;

public class MobileApp extends DriverFactory{

    PropLocation file = new PropLocation();
    ReadPropertiesValues loc = new ReadPropertiesValues(file.location());
    ReadPropertiesValues elementLoc = new ReadPropertiesValues(file.elementLocation());

    static WebDriver driver;
    public MobileApp(WebDriver driver) throws MalformedURLException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public MobileApp accept_terms_and_conditions() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id(elementLoc.readProperty("terms_conditions"))).click();
        return this;
    }
    public MobileApp skip_tutorials() throws InterruptedException {
        Thread.sleep(5000);
        Dimension size = this.driver.manage().window ().getSize();
        int startX = (int) (size.width * 0.70);
        int startY = size.height / 2;
        int endX = (int) (size.width * 0.30);
        //int endY = (int) (startY * 0.75 * -1);
        TouchAction action = new TouchAction ((PerformsTouchActions) this.driver);
        action.press (startX, startY).moveTo (endX, startY).release ().perform ();
        Thread.sleep(5000);
        driver.findElement(By.id(elementLoc.readProperty("skip_tutorial"))).click();
        return this;
    }
    public MobileApp click_hamburger_menu() throws InterruptedException {
        Thread.sleep(10000);
        if(driver.findElement(By.className(elementLoc.readProperty("close_ad"))).isDisplayed())
        {
            driver.findElement(By.className(elementLoc.readProperty("close_ad"))).click();
            System.out.println("Hello");
        }
        System.out.println("Hello1");
        Thread.sleep(5000);
        driver.findElement(By.className(elementLoc.readProperty("hamburger_menu"))).click();
        return this;
    }

    public MobileApp enter_Login_Credentials() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id(elementLoc.readProperty("mobile_login_button"))).click();
        Thread.sleep(5000);
        driver.findElement(By.id(elementLoc.readProperty("app_login_id"))).sendKeys("digitaltest1");
        driver.findElement(By.id(elementLoc.readProperty("app_password"))).sendKeys("Sphdigital1");
        return this;
    }
    public MobileApp click_continue_button() throws InterruptedException {
        driver.findElement(By.id(elementLoc.readProperty("continue_button_app"))).click();
        return this;
    }
    public MobileApp verify_userName() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.className(elementLoc.readProperty("hamburger_menu"))).click();
        String User_Name =driver.findElement(By.id(elementLoc.readProperty("verify_username_app"))).getText();
        System.out.println("User is logged in: "+User_Name);
        Dimension size = this.driver.manage().window ().getSize();
        int startX = (int) (size.width * 0.70);
        int startY = size.height / 2;
        int endX = (int) (size.width * 0.30);
        //int endY = (int) (startY * 0.75 * -1);
        TouchAction action = new TouchAction ((PerformsTouchActions) this.driver);
        action.press (startX, startY).moveTo (endX, startY).release ().perform ();
        return this;
    }
    public MobileApp click_latest_tab() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.xpath(elementLoc.readProperty("latest_tab"))).click();
        //driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1'])")).click();

        return this;
    }
    public MobileApp click_first_article() throws InterruptedException {
        Thread.sleep(5000);
        String Article_headline = driver.findElement(By.xpath(elementLoc.readProperty("app_article_headline"))).getText();
        System.out.println("Article Headline is" + Article_headline);
        driver.findElement(By.xpath(elementLoc.readProperty("app_article_headline"))).click();
        return this;
    }
    public MobileApp verify__first_article() throws InterruptedException {
        Thread.sleep(5000);
        WebElement Article_Headline_Text = driver.findElement(By.id(elementLoc.readProperty("article_headline")));
        String Read_Article_Headline=Article_Headline_Text.getText();
        System.out.println("Article Headline is: "+Read_Article_Headline);
        WebElement Article_Headline_Image = driver.findElement(By.className(elementLoc.readProperty("app_article_image")));
        Boolean ImagePresent_MainArticle_Verify = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", Article_Headline_Image);
        if (!ImagePresent_MainArticle_Verify)
        {
            System.out.println("Image is not present");
        }
        else
        {
            System.out.println("Image is Present");
        }

        return this;
    }




}
