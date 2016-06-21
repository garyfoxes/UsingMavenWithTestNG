package testngexamples.testnggroups;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by gfox on 04/05/2016.
 */
public class Group1Test {

    private Logger logger = LogManager.getLogger();

    @Parameters({"name"})
    @Test(groups = {"Testing Groups"}, priority = 5)
    public void runGroup1(String name) {
        logger.log(Level.DEBUG, "Running group1 currently " + 4 * 5 + " and name is " + name);
    }
}
