package testngexamples.seleniumgrid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by gfox on 24/06/2016.
 */
public class SeleniumGridExample extends TestSuiteBase {
    private Logger logger = LogManager.getLogger();


    @Test
    public void launchBrowser() throws IOException {
        System.out.println(getHostName(((RemoteWebDriver) driver).getSessionId()));
        driver.get("http://redcafe.net");
        logger.log(Level.INFO, "We have navigated to the url in " + getBrowser());


    }

    @AfterMethod
    public void cleanUp(ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(10000);
        driver.quit();
    }

}
