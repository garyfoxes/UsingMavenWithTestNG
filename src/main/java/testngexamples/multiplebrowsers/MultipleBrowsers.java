package testngexamples.multiplebrowsers;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by gfox on 17/06/2016.
 */
public class MultipleBrowsers {
    private Logger logger = LogManager.getLogger();
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


    @Parameters({"browserType"})
    @Test
    public void launchBrowser(String browserType) throws IOException {
        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/selenium_standalone/windows/googlechrome/64bit/chromedriver2");
            driver = new ChromeDriver();
            driver.get("http://redcafe.net");
            logger.log(Level.INFO, "We have navigated to the url in Chrome");

        } else {
            driver = new SafariDriver();
            driver.get("http://redcafe.net");
            logger.log(Level.INFO, "We have navigated to the url in Safari");
        }

    }

    @AfterMethod
    public void cleanUp(ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(10000);
        if (result.getStatus() == ITestResult.SUCCESS) {
            takeScreenShot();
        }
        driver.quit();
    }

    public void takeScreenShot() throws IOException {
        String filename = new Date().toString() + ".png";
        String directory = new File("").getAbsolutePath() + "/";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
    }
}
