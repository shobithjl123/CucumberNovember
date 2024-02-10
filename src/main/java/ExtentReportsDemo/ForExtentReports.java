package ExtentReportsDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReports {

    public static String screenshot(WebDriver driver) throws IOException {
        // 1. create an object reference of TakesScreenshot as ts.

        //assign the current driver to it.

        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. Call the method getScreenshotAs() using ts

        // that is an Object reference of TakesScreeshot

        //Store the result returned by this method in to a file object.

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyMMdd_hhmmss").format(new Date());
        String fileName = "TestScreenshot" + timeStamp + ".png";

        //3. Convert this file object in to a real image file.
        //if needed download common io jar

        FileUtils.copyFile(srcFile, new File("Report\\Screenshot\\" + fileName));
        return fileName;
    }

}
