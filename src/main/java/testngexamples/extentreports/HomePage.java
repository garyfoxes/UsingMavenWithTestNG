package testngexamples.extentreports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by gfox on 21/06/2016.
 */
public class HomePage {
    ExtentTest test;
    WebDriver driver = null;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public HomePage clickSignUp() {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signup link");
        return this;
    }

    public HomePage clickLoginLink() {
        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");
        return this;
    }

    public HomePage enterEmailAndPassword() throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys("test1@email.com");
        test.log(LogStatus.INFO, "Enter email");
        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Enter password");
        WebElement goButton = driver.findElement(By.id("memberLoginDialogsubmitButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");
        Thread.sleep(3000);
        return this;
    }

    public WebElement getEmailWithText(){
        WebElement welcomeText = null;
        try {
            welcomeText = driver.findElement(By.xpath("//input[text()='test1@email.com']"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       return welcomeText;
    }
}
