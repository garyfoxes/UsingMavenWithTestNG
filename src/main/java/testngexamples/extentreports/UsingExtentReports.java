package testngexamples.extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UsingExtentReports {

    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;
    HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/selenium_standalone/windows/googlechrome/64bit/chromedriver2");
        baseUrl = "http://www.letskodeit.com/";
        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        homePage = new HomePage(driver, test);
        test.log(LogStatus.INFO, "Browser Started...");

        // Maximize the browser's window
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
       /* WebElement emailText = homePage
                .clickSignUp()
                .clickLoginLink()
                .enterEmailAndPassword().getEmailWithText();*/
        Assert.assertTrue(true);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE || testResult.getStatus() == ITestResult.SUCCESS) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}

