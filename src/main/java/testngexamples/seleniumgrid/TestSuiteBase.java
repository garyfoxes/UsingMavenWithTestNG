package testngexamples.seleniumgrid;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gfox on 24/06/2016.
 */
public class TestSuiteBase {

    private Logger logger = LogManager.getLogger();
    protected WebDriver driver;
    private String browser;
    private String hubUrl;
    DesiredCapabilities capabilities;

    @Parameters({"browserType", "platform"})
    @BeforeTest
    public void setup(String browserType, String platform) throws MalformedURLException {
        this.browser = browserType;
        driver = getDriverInstance(browserType, platform);

    }

    public WebDriver getDriverInstance(String browserType, String platform) throws MalformedURLException {
        hubUrl = "http://192.168.192.16:4444/wd/hub";

        if (browserType.equalsIgnoreCase("Safari")) {
            capabilities = DesiredCapabilities.safari();
            capabilities.setBrowserName(BrowserType.SAFARI);
        } else {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName(BrowserType.CHROME);
        }
        if (platform.equalsIgnoreCase("Mac")) {
            capabilities.setPlatform(Platform.MAC);
        } else {
            capabilities.setPlatform(Platform.WIN10);
        }


        driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        return driver;


    }

    public String getBrowser() {
        return this.browser;
    }


    public String getHostName(SessionId session) throws IOException {
        String hostName = "localhost";
        int port = 4444;
        URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + session);
        logger.log(Level.INFO, "URL is : " + sessionURL);
        HttpURLConnection huc = (HttpURLConnection) sessionURL.openConnection();
        huc.setRequestMethod("POST");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(huc.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        logger.log(Level.INFO, response.toString());
        JsonParser parser = new JsonParser();
        JsonObject objToReturn = (JsonObject) parser.parse(response.toString());
        logger.log(Level.INFO, objToReturn.toString());
        logger.log(Level.INFO, objToReturn.get("proxyId"));

        return new URL(objToReturn.get("proxyId").getAsString()).getHost();

    }
}
