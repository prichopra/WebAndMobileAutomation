package com.cucumber.stepdefinitions;

import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;

import static framework.DriverFactory.driver;

public class Stepdefs_WebApp {
	LoginPage loginPage = new LoginPage(driver);

    public Stepdefs_WebApp() throws MalformedURLException {
    }


    @Given("^I want to launch the Straits Times website$")
    public void i_want_to_launch_straits_time_site() throws IOException, InterruptedException {
    	loginPage.launch_Strait_Times();
        Reporter.addStepLog("User wants to launch the Straits Time site");
    }
    @When("^I want to click on the login link$")
    public void i_want_to_click_the_login_link() throws IOException, InterruptedException {
        loginPage.login_StraitTimes();
        Reporter.addStepLog("User wants to click the login link");
    }
    @And("^I want to login the straits time site as (.+) and (.+)$")
    public void i_want_to_login_straits_time(String UserName, String Password) throws IOException, InterruptedException {
        loginPage.enter_Login_Credentials(UserName, Password);
        Reporter.addStepLog("Login to the site with the ID and password provided");
        Reporter.addScenarioLog("Login to the site with the ID and password provided");
    }
    @And("^I want to verify the user has been logged in as (.+)$")
    public void i_want_to_verify_that_the_user_is_logged_in(String UserName) throws IOException, InterruptedException {
        loginPage.user_logged_in(UserName);
        Reporter.addStepLog("Verify the user has been logged in");
        Reporter.addScenarioLog("Verify the user has been logged in");
    }

    @And("^I want to verify and read the main article has a picture or video$")
    public void i_want_to_verify_the_main_article() throws IOException, InterruptedException {
        loginPage.verify_main_article_image();
        Reporter.addStepLog("Verify that the main article has a picture/video");
        Reporter.addScenarioLog("Verify that the main article has a picture/video");
    }
    @And("^I want to click the main article$")
    public void i_want_to_click_the_main_article() throws IOException, InterruptedException {
        loginPage.click_main_article();
        Reporter.addStepLog("Click on the main article");
        Reporter.addScenarioLog("Click on the main article");
    }
    @Then("^I want to verify the main article page$")
    public void i_want_to_verify_the_main_article_page() throws IOException, InterruptedException {
        loginPage.verify_main_article_page();
        Reporter.addStepLog("Verify that the page has been navigated to the main article, and the picture/video is present in the article.");
        Reporter.addScenarioLog("Verify that the page has been navigated to the main article, and the picture/video is present in the article.");
    }






}
