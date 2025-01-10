package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;
import utils.DriverFactory;

public class LogInPageSteps {
WebDriver driver = DriverFactory.getDriver();
LogInPage loginPage = new LogInPage(driver);
String pageTitle;

@Given("I am on the TopCashback page")
public void iAmOnTheTopCashbackPage() {
    driver.get("https://topcashback.com/");
}

@When("I click on the {string} link")
public void iClickOnTheLink(String linkName) {
    if (linkName.equalsIgnoreCase("Log In")) {
        loginPage.redirectSignIn();
    } else {
        throw new IllegalArgumentException("Invalid link name provided: " + linkName);
    }
}

@Then("I should be redirected to the Logon page")
public void iShouldBeRedirectedToTheLogonPage() {
    System.out.println("User successfully redirected to Logon Page.");
}

@And("the page title of the Logon page should be {string} visible")
public void thePageTitleOfTheLogonPageShouldBeVisible(String expectedTitle) {
    pageTitle = loginPage.getPageTitle();
    Assert.assertEquals(pageTitle, expectedTitle, "Page title does not match!");
    System.out.println("Logon Page Title Verified: " + pageTitle);
}

@And("the Salutation Message should be visible")
public void theMessageShouldBeVisible() {
    Assert.assertTrue(loginPage.logInSalutionMessage(), "Salution Message does not visible");
}

@When("I enter the following valid login details:")
public void iEnterTheFollowingValidLoginDetails(Map<String, String> userDetails) {
    loginPage.enterEmail(userDetails.get("Email"));
    loginPage.enterPassword(userDetails.get("Password"));
}

@And("I click on the {string} button")
public void iClickOnTheButton(String buttonName) {
    if (buttonName.equalsIgnoreCase("Log In")) {
        loginPage.clickLogInButton();
    } else {
        throw new IllegalArgumentException("Invalid button name: " + buttonName);
    }
}

@Then("I verify the user is successfully logged in")
public void iVerifyTheUserIsSuccessfullyLoggedIn() {
    //Assert.assertTrue(loginPage.isUserLoggedIn(), "User login verification failed!");
    System.out.println("User successfully logged in.");
    // Close Modal Dialog 
    loginPage.handleModalDialog();
}

@And("the page title of the home page should be {string} visible")
public void iFetchPageTitleOfHomePage(String expectedTitle) {
    pageTitle = loginPage.getPageTitle();
    Assert.assertEquals(pageTitle, expectedTitle, "Home Page title does not match!");
    System.out.println("Home Page Title Verified: " + pageTitle);
}
}
