package testngexamples.firsttest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by gfox on 05/05/2016.
 */
@Test(groups = {"testNGExample"})
public class TestNGExampleTest {

    private Logger logger = LogManager.getLogger();

    @Test(description = "Hello", priority = 2)
    @Parameters("name")
    public void printOutMessage(@Optional("") String name) {
        logger.log(Level.DEBUG, "Inside printOutMessage Test " + name);
        Assert.assertTrue(isOAP(90));
    }

    @Test(priority = 3, description = "Add Some Numbers")
    public void addNumbers() {
        logger.log(Level.DEBUG, "In Add Numbers Test", true);
        int num = add(2, 0);
        Assert.assertEquals(num, 2);
    }

    @Test(priority = 4, description = "Subtract Some Numbers")
    @Parameters({"value"})
    public void subtractNumbers(@Optional("") String value) {
        SoftAssert sa = new SoftAssert();
        logger.log(Level.DEBUG, "In Subtract Numbers Test", true);
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
