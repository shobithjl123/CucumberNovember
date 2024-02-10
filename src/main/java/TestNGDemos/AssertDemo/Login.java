package TestNGDemos.AssertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

    //WebDriver driver;

    @Test
    public void loginTest1()
    {
      WebDriver driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://stock.scriptinglogic.org");

   /*     //driver.get("https://stock.scriptinglogic.org");
        driver.get("https://stock.scriptinglogic.org");*/
        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin= driver.findElement(By.name("submit"));
        btnLogin.click();

       /* String expected="https://stock.scriptinglogic.org/dashboard.php";
        String actual= driver.getCurrentUrl();*/

        /*String expected="POSNIC - Dashboard";
        String actual= driver.getTitle();*/

        String actual="";
        String expected="Dashboard";
        try {
             actual = driver.findElement(By.xpath("//a[.='Dashboard']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"this is not Dashboard page");
    }
}
