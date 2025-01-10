package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            driver.quit(); // Close any existing session
            driver = null;
           }
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @After
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
