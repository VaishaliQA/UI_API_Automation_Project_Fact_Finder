package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    WebDriver driver;
    private WebDriverWait wait;


    @FindBy(id = "emailInput")
    private WebElement userEmailInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "lohformSelect")
    WebElement howDidYouHearDropdown;

    @FindBy(id ="btnJoin")
    private WebElement joinForFreeButton;

    @FindBy(xpath ="//span[text()='Members login']") 
    WebElement headerTitle;

     public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

      // Method to get the title of the page
    public String getPageTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("loh-logo")));
        return driver.getTitle();
    }

    public void enterEmail(String email) {
        userEmailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

     // Method to select a value from the dropdown by visible text
    public void selectHowDidYouHear(String optionText) {
        Select select = new Select(howDidYouHearDropdown);
        select.selectByVisibleText(optionText);
    }

    public void clickJoinForFreeButton() {
        joinForFreeButton.click();
    }

    public boolean isSignUpSuccessful() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Members login']")));
        return headerTitle.isDisplayed();
    }

    public String getHeaderTitle() {
        return headerTitle.getText();
    }
}
