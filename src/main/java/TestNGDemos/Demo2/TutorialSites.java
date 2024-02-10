package TestNGDemos.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutorialSites extends OpenCloseBrowser {


    @Test
    public void scriptinglogic()
    {
        driver.get("https://scriptinglogic.com");
    }
    @Test
    public void tutorialspoint()
    {
        driver.get("https://tutorialspoint.com");
    }
    @Test
    public void javatpoint()
    {
        driver.get("https://javatpoint.com");
    }
    @Test
    public void w3schools()
    {
        driver.get("https://w3schools.com");
    }
}
