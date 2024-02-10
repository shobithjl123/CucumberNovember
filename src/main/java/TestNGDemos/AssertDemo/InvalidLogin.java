package TestNGDemos.AssertDemo;

import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLogin {

    @Test(enabled = false)
    public void loginTest1()
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin= driver.findElement(By.name("submit"));
        btnLogin.click();

        String actual="";
        String expected="Wrong Username or Password";
        try {
            actual = driver.findElement(By.xpath("//div[.='Wrong Username or Password']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");
    }

    @Test
    public void loginTest2()
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys(" ");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");

        WebElement btnLogin= driver.findElement(By.name("submit"));
        btnLogin.click();

       /* String actual="";
        String expected="Wrong Username or Password";
        try {
            actual = driver.findElement(By.xpath("//div[.='Wrong Username or Password']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");*/

        String[] expected={"PLEASE ENTER A USERNAME","PLEASE PROVIDE A PASSWORD"};

        String[] actual = new String[2];
        try
        {
            actual[0]= driver.findElement(By.xpath("//label[@for='login-username'][@class='error']")).getText();
            actual[1]= driver.findElement(By.xpath("//label[@for='login-password'][@class='error']")).getText();
        }

        catch (Exception e)
        {

        }

        System.out.println("Expected Result...");
        for (int i=0;i<expected.length;i++)
            System.out.println(expected[i]);

        System.out.println("Actual Result");

        for (int i=0;i<actual.length;i++)
            System.out.println(actual[i]);

        Assert.assertEquals(actual,expected,"incorrect or no error message");

    }
}
