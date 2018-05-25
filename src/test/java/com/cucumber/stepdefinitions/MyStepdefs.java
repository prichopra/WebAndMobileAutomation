package com.cucumber.stepdefinitions;

import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class MyStepdefs {
	LoginPage loginPage = new LoginPage();

    public MyStepdefs() throws MalformedURLException {
    }


    @Given("^I want to launch the Straits Times site$")
    public void i_want_to_launch_straits_time_site() throws IOException, InterruptedException {
    	loginPage.launch_Strait_Times();
    	loginPage.login_StraitTimes();
        Reporter.addStepLog("User wants to launch the Straits Time site");
    }

    @When("^I want to login the straits time site as (.+) and (.+)$")
    public void i_want_to_login_straits_time(String UserName, String Password) throws IOException, InterruptedException {
        loginPage.enter_Login_Credentials(UserName, Password);
        Reporter.addStepLog("Gmail is launched");
        Reporter.addScenarioLog("Gmail is launched");
    }
    

    

    
}
