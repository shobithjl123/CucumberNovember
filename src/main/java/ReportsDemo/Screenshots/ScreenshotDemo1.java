package ReportsDemo.Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotDemo1 {
    @Test

    public void getScreenshot() throws IOException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://facebook.com");
        driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.15.1");

        // 1. create an object reference of TakesScreenshot as ts.

        //assign the current driver to it.

       // TakesScreenshot ts= (TakesScreenshot) driver;

        //find the webelement

        //WebElement element = driver.findElement(By.name("login"));

        WebElement element = driver.findElement(By.xpath("//main[@class='center']"));

        // 2. Call the method getScreenshotAs() using ts

        // that is an Object reference of TakesScreeshot

        //Store the result returned by this method in to a file object.

        File srcFile = element.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyMMdd_hhmmss").format(new Date());
        String fileName = "TestScreenshot" + timeStamp+".png";

        //3. Convert this file object in to a real image file.
        //if needed download common io jar

        FileUtils.copyFile(srcFile,new File("D:\\Screenshots\\"+fileName));






    }
}
