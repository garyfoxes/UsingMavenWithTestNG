package paralleltests;

import org.testng.annotations.*;

/**
 * Created by gfox on 18/05/2017.
 */
public class TestParallelClass1 {

    private String testName;

    @BeforeClass
    @Parameters({"test-name"})
    public void beforeClass(String testName) {
        this.testName = testName;
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class 1. Thread id is: " + id + " for test " + this.testName);
    }

    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method One Class 1. Thread id is: " + id + " for test " + this.testName);
    }

    @Test
    public void testMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method Two Class 1. Thread id is: " + id + " for test " + this.testName);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-class 1. Thread id is: " + id + " for test " + this.testName);
    }
}
