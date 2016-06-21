package testngexamples;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.IOException;

/**
 * Created by gfox on 20/06/2016.
 */


public class SeleniumListeners implements ITestListener, ISuiteListener, IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

        String message = "About To Execute Method " + iInvokedMethod.getTestMethod().getRealClass().getSimpleName() + "." +
                iInvokedMethod.getTestMethod().getMethodName() + "\n";
        Reporter.log(message, true);
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

        String message = "Method " + iInvokedMethod.getTestMethod().getRealClass().getSimpleName() + "." +
                iInvokedMethod.getTestMethod().getMethodName() + " has been executed" + "\n";
        Reporter.log(message, true);
    }

    public void onStart(ISuite iSuite) {
        Reporter.log("On Test Suite Start - About To Begin Executing Suite " + iSuite.getName() + "\n", true);


    }

    public void onFinish(ISuite iSuite) {

        Reporter.log("On Test Suite Finish - About To Finish Executing Suite " + iSuite.getName() + "\n", true);
    }

    //This starts before every @Test method
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log("########### Thread Name " + Thread.currentThread().getId() + "###############\n",true);
        Reporter.log("On Test Start - About To Execute Test " + iTestResult.getName() + "\n", true);
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver webdriver = ((testngexamples.multiplebrowsers.MultipleBrowsers) currentClass).getDriver();
        try {
            ((testngexamples.multiplebrowsers.MultipleBrowsers) currentClass).takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printTestResults(iTestResult);
    }

    //This method will print out whether a test has passed or failed
    private void printTestResults(ITestResult iTestResult) {
        String status = null;
        switch (iTestResult.getStatus()) {
            case ITestResult.SUCCESS:
                status = "Pass";
                break;
            case ITestResult.FAILURE:
                status = "Fail";
                break;
            case ITestResult.SKIP:
                status = "Skipped";

        }
        Reporter.log("Test Status: " + status + "\n", true);

    }

    public void onTestFailure(ITestResult iTestResult) {
        printTestResults(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        printTestResults(iTestResult);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    //Thios starts before the main test defined in your xml file
    public void onStart(ITestContext iTestContext) {
        Reporter.log("On Test Start - About To Begin Executing Test " + iTestContext.getName() + "\n", true);
    }

    public void onFinish(ITestContext iTestContext) {
        Reporter.log("On Test Finish - About To Begin Finishing Test " + iTestContext.getName() + "\n", true);
    }
}
