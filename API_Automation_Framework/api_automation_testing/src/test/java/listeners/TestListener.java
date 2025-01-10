package listeners;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    String reportPath = "./test-output/ExtentReport.html";
    File reportDir = new File("./test-output");
    if (!reportDir.exists()) {
        reportDir.mkdirs(); // Create directory if it doesn't exist
    }
        // Initialize ExtentReports with ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        
    }

    @Override
    public void onTestStart(ITestResult result) {
         // Start logging a test case
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
         // Log success
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure with stack trace
        test.fail("Test Failed: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
         // Flush the report
        extentReports.flush();
    }
}
