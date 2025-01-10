package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    WebDriver driver;
    private WebDriverWait wait;

    
    @FindBy(id = "ctl00_BodyMain_SignINButton")
    private WebElement signInLink;

    @FindBy(id = "ctl00_GeckoOneColPrimary_Login_lblSalutationMsg")
    private WebElement logInSalutaionMessage;

    @FindBy(id = "txtEmail")
    private WebElement emailInput;

    @FindBy(id = "loginPasswordInput")
    private WebElement passwordInput;

    @FindBy(id = "Loginbtn")
    private WebElement logInButton;

    @FindBy(id = "ctl00_ctl27_lblAccount")
    private WebElement accountHeader;


     public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void redirectSignIn() {
        // Explicitly wait for elment to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

     // Method to get the title of the page
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean logInSalutionMessage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_GeckoOneColPrimary_Login_lblSalutationMsg")));
        return logInSalutaionMessage.isDisplayed();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    // Handle dialog modal after login
    public void handleModalDialog()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeToolbarPopup"))).click();
    }

    public boolean  verifyAccountTag()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ctl27_lblAccount")));
        return accountHeader.isDisplayed();
    }

    
}
