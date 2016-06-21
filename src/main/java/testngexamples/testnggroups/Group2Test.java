package testngexamples.testnggroups;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by gfox on 04/05/2016.
 */
public class Group2Test {

    private Logger logger = LogManager.getLogger();

    @Test(groups = {"Testing Groups"})
    public void arunGroup2() {
        logger.log(Level.DEBUG,"Running group2 currently " + 4 * 4);
    }
}
