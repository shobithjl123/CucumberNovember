package TestNGDemos.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class OpenCloseBrowser {
    public static WebDriver driver;
    @BeforeClass

    public void openBrowser()
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://stock.scriptinglogic.org");
    }

    @AfterClass

    public void closeBrowser1() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
