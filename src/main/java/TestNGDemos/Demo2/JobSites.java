package TestNGDemos.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites extends OpenCloseBrowser {


    @Test
    public void naukri()
    {
        driver.get("https://naukri.com");
        Assert.assertEquals(driver
                .getTitle(),"my naukri","this is not  a correct page.");
    }
    @Test
    public void foundit()
    {
        driver.get("https://foundit.in");
    }
    @Test
    public void shine()
    {
        driver.get("https://shine.com");
    }
    @Test
    public void timesjobs()
    {
        driver.get("https://timesjobs.com");
    }
}
