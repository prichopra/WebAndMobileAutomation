package com.cucumber.stepdefinitions;

import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.MobileApp;

import java.io.IOException;
import java.net.MalformedURLException;

import static framework.DriverFactory.driver;

public class StepDefs_MobileApp {
    MobileApp mobileApp = new MobileApp(driver);

    public StepDefs_MobileApp() throws MalformedURLException {
    }


    @Given("^I want to launch the Straits Time site and accept the terms and conditions$")
    public void i_want_to_accept_the_terms_and_conditions() throws IOException, InterruptedException {
        mobileApp.accept_terms_and_conditions();
        Reporter.addStepLog("User wants to launch the Straits Time site and accept the terms and conditions");
        Reporter.addScenarioLog("User wants to launch the Straits Time site and accept the terms and conditions");
    }
    @When("^I want to skip the tutorials$")
    public void i_want_to_skip_the_tutorials() throws IOException, InterruptedException {
        mobileApp.skip_tutorials();
        Reporter.addStepLog("User wants to skip the tutorials");
        Reporter.addScenarioLog("User wants to skip the tutorials");
    }
    @And("^I want to click the hamburger menu$")
    public void i_want_to_click_the_hamburger_menu() throws IOException, InterruptedException {
        mobileApp.click_hamburger_menu();
        Reporter.addStepLog("User wants to click the hamburger menu");
        Reporter.addScenarioLog("User wants to click the hamburger menu");
    }
    @And("^I want to enter the login credentials$")
    public void i_want_to_enter_the_login_credentials() throws IOException, InterruptedException {
        mobileApp.enter_Login_Credentials();
        Reporter.addStepLog("User wants to enter the login credentials");
        Reporter.addScenarioLog("User wants to enter the login credentials");
    }
    @And("^I want to click the continue button$")
    public void i_want_to_click_the_continue_button() throws IOException, InterruptedException {
        mobileApp.click_continue_button();
        Reporter.addStepLog("User wants to click the continue button");
        Reporter.addScenarioLog("User wants to click the continue button");
    }
    @And("^I want to verify the username$")
    public void i_want_to_verify_the_username() throws IOException, InterruptedException {
        mobileApp.verify_userName();
        Reporter.addStepLog("User wants to verify the username");
        Reporter.addScenarioLog("User wants to verify the username");
    }
    @And("^I want to click the latest tab$")
    public void i_want_to_click_the_latest_tab() throws IOException, InterruptedException {
        mobileApp.click_latest_tab();
        Reporter.addStepLog("User wants to click the latest tab");
        Reporter.addScenarioLog("User wants to click the latest tab");
    }
    @And("^I want to click the first article on the latest tab$")
    public void i_want_to_click_first_article_the_latest_tab() throws IOException, InterruptedException {
        mobileApp.click_first_article();
        Reporter.addStepLog("User wants to click the first article on the latest tab");
        Reporter.addScenarioLog("User wants to click the first article on the latest tab");
    }
    @And("^I want to verify the first article displayed on the latest tab$")
    public void i_want_to_verify_the_articles_displayed_on_latest_tab() throws IOException, InterruptedException {
        mobileApp.verify__first_article();
        Reporter.addStepLog("User wants to verify the first article displayed on the latest tab");
        Reporter.addScenarioLog("User wants to verify the first article displayed on the latest tab");
    }

}
