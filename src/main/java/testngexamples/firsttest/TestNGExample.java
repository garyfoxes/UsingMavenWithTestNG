package testngexamples.firsttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by gfox on 05/05/2016.
 */
public class TestNGExample {

    @Test(priority = 0,description = "Hello")
    @Parameters("name")
    public void printOutMessage(@Optional("")String name) {
        System.out.println("Inside printOutMessage Test" + name);
        Assert.assertTrue(isOAP(90));
    }

  @Test(priority = 2, description = "Add Some Numbers")
    public void addNumbers() {
        Reporter.log("In Add Numbers Test", true);
        int num = add(2, 0);
        Assert.assertEquals(num, 2);
    }

    @Test(priority = 3, description = "Subtract Some Numbers")
    @Parameters({"value"})
    public void subtractNumbers(@Optional("") String value) {
        SoftAssert sa = new SoftAssert();
        Reporter.log("In Subtract Numbers Test", true);
        int num = add(2, 0);
        sa.assertEquals(num, 2, "Numbers Are Equal");
        sa.assertTrue(num == 2);
        sa.assertAll();
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public boolean isOAP(int age) {
        return age > 64;
    }
}
