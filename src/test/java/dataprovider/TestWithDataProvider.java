package dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by gfox on 04/05/2016.
 */
public class TestWithDataProvider {

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
    }

    @DataProvider(name = "Gary Object")
    public static Object[][] parameters() {
        return new Object[][]{{new TestObject("Gary", 31, "Dublin", true)}};
    }

    @Test(dataProvider = "test1", priority = 0)
    public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
        System.out.println(inputNumber + " " + expectedResult);
        Assert.assertEquals(expectedResult, PrimeNumberChecker.validate(inputNumber));
    }

    @Test(dataProvider = "Gary Object", priority = 1)
    public void checkIncome(TestObject obj) {
        Assert.assertEquals(40000.0, obj.getPredictedIncome());
    }
}
