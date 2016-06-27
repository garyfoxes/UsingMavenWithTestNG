package testngexamples.fileupload;

/**
 * Created by gfox on 22/06/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class FileUpload {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/selenium_standalone/windows/googlechrome/64bit/chromedriver2");
        driver = new ChromeDriver();
        baseUrl = "https://www.gmail.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void fileUpload() throws AWTException, InterruptedException {
        driver.findElement(By.id("Email")).sendKeys("*******");//enter real email address e.g joe1984(no need for @gmail.com)
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("*****");//real password here
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
        driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("*******");//receipent email address
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
        WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
        fileInput.click();

        String filePath = "//Users//gfox//Desktop//testfile.txt.rtf";
        StringSelection stringSelection= new StringSelection(filePath);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);//this copies text to the clipboard
        Robot robot = new Robot();


        //On Windows Machine
     /*   Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/

        // Cmd + Tab
        robot.keyPress(KeyEvent.VK_META);//this is the mac command key
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(2000);
        // Goto Window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        // Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        // Hit Enter Key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Send']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

