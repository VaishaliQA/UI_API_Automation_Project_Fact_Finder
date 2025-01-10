package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import utils.DriverFactory;

public class LandingPageSteps {

    WebDriver driver = DriverFactory.getDriver();
    LandingPage landingPage = new LandingPage(driver);
    String pageTitle;

    @Given("I am on the TopCashBack landing page")
    public void iAmOnTheTopCashBackLandingPage() {
        driver.get("https://topcashback.com/");
    }

    @When("I fetch the page title of landing page")
    public void iFetchThePageTitle() {
        pageTitle = landingPage.getPageTitle();
    }

    @Then("I verify the page title is {string} visible on the page")
    public void iVerifyThePageTitleShouldBeVisibleOnThePage(String expectedTitle) {
        Assert.assertEquals(pageTitle, expectedTitle, "Page title does not match!");
        System.out.println("Page Title Verified: " + pageTitle);
        
    }

    @When("I enter valid sign-up details")
    public void iEnterValidSignUpDetails(Map<String, String> userDetails) {
        landingPage.enterEmail(userDetails.get("Email"));
        landingPage.enterPassword(userDetails.get("Password"));
        landingPage.selectHowDidYouHear(userDetails.get("HowDidYouHear"));
    }

    @And("I click on the Join for Free button")
    public void iClickOnTheJoinForFreeButton() {
        landingPage.clickJoinForFreeButton();
        
    }

    @Then("I verify the user is successfully registered")
    public void iVerifyTheUserIsSucessfullyRegistered() {
        Assert.assertTrue(landingPage.isSignUpSuccessful(), "Sign-up was not successful!");
        System.out.println("User successfully registered.");
    }

    @And("I verify title of header")
    public void iVerifyTitleOfHeader() {
        String actualHeaderTitle = landingPage.getHeaderTitle();
        String expectedHeaderTitle = "Members login"; // Replace with the actual expected title
        Assert.assertEquals(actualHeaderTitle, expectedHeaderTitle, "Header title mismatch!");
        System.out.println("Header title verified successfully: " + actualHeaderTitle);
    
    }
    
}
