package TestNGDemos.AssertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomer2 {

    @Test
    public void addCustomer()
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

        driver.findElement(By.linkText("Add Customer")).click();

        String name="AnkitSharma";

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='buyingrate']")).sendKeys("5950504");
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Muniraju layout");
        driver.findElement(By.xpath("//input[@id='sellingrate']")).sendKeys("4744812");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String expected = "Customer Details Added !";
        String actual=" ";

        try
        {
            actual=driver.findElement(By.xpath("//div[@class='confirmation-box round']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("Expected"+expected);
        System.out.println("Actual "+actual);

        boolean result = actual.contains(expected);

        Assert.assertTrue(result,"user is not added");

       // Assert.assertEquals(actual,expected,"User details not added");




    }
}
