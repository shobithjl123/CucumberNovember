package TestNGDemos;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNG1 {

    WebDriver driver;
    @BeforeMethod

    public void openBrowser()
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://stock.scriptinglogic.org");
    }



@Test
    public void loginTest1()
  {
    /*  WebDriver driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://stock.scriptinglogic.org");*/

      //driver.get("https://stock.scriptinglogic.org");
      driver.get("https://stock.scriptinglogic.org");
      WebElement txtUsername = driver.findElement(By.id("login-username"));
      txtUsername.sendKeys("admin");

      WebElement txtPassword = driver.findElement(By.id("login-password"));
      txtPassword.sendKeys("admin");

      WebElement btnLogin= driver.findElement(By.name("submit"));
      btnLogin.click();
  }

    @Test
    public void loginTest2()
    {
       /* WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");
*/
        //driver.get("https://stock.scriptinglogic.org");
        driver.get("https://stock.scriptinglogic.org");
        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("abcd");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("efgh");

        WebElement btnLogin= driver.findElement(By.name("submit"));
        btnLogin.click();
    }

    @Test
    public void loginTest3()
    {
        /*WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");*/

      //  driver.get("https://stock.scriptinglogic.org");
        driver.get("https://stock.scriptinglogic.org");
        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");

        WebElement btnLogin= driver.findElement(By.name("submit"));
        btnLogin.click();
    }

    @AfterMethod

    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}
