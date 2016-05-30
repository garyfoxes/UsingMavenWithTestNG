package testngexamples.testnggroups;

import org.testng.annotations.Test;

/**
 * Created by gfox on 04/05/2016.
 */
public class Group1 {

    @Test(groups = "Testing Groups")
    public void runGroup1() {
        System.out.println("Running group1 currently " + 4 * 5);
    }
}
