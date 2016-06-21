package testngexamples.extentreports;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

/**
 * Created by gfox on 21/06/2016.
 */
public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String path = new File("").getAbsolutePath() + "/extentReport.html";
        extent = new ExtentReports(path, false);
        //the following is optional
        extent
                .addSystemInfo("Selenium Version", "2.53.0")
                .addSystemInfo("Platform", "Mac");
        return extent;
    }
}
