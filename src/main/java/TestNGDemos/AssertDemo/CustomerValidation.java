package TestNGDemos.AssertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerValidation {

    @Test
    public void addCustomer() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actual="";
        String expected="PLEASE ENTER A CUSTOMER NAME";

        try
        {
            actual=driver.findElement(By.xpath("//label[@for='name']")).getText();
        }

        catch (Exception e)
        {

        }
        System.out.println("Actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"Validation is not present");
    }
}
