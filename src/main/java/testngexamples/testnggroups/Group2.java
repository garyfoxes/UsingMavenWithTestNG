package testngexamples.testnggroups;

import org.testng.annotations.Test;

/**
 * Created by gfox on 04/05/2016.
 */
public class Group2 {

    @Test(groups = "Testing Groups")
    public void runGroup2() {
        System.out.println("Running group2 currently " + 4 * 4);
    }
}
