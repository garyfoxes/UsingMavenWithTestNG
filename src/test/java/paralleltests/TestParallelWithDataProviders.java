package paralleltests;

import org.testng.annotations.*;
import testngexamples.dataprovider.TestObject;

/**
 * Created by gfox on 19/05/2017.
 */
public class TestParallelWithDataProviders {

    private String team;

    @DataProvider(name = "Gary Object", parallel = true)
    public static Object[][] parameters() {
        return new Object[][]{{new TestObject("Gary", 31, "Dublin", true)}, {new TestObject("Joe", 33, "Antrim", false)}};
    }

    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before Method With Thread Id " + id);
    }

    @BeforeTest
    public void beforeTest() {
        this.team = "Man Utd";
        long id = Thread.currentThread().getId();
        System.out.println("Before Test With Thread Id " + id);
    }


    @Test(dataProvider = "Gary Object", priority = 1)
    public void checkIncome(TestObject obj) {
        long id = Thread.currentThread().getId();
        System.out.println("Team Is " + this.team);
        System.out.println("This is " + obj.getName() + " and his age is " + obj.getAge() + " with Thread id " + id);
    }
}
