package TestNGDemos.AssertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddCustomer3 {

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

        String name="Sh";

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='buyingrate']")).sendKeys("59");
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Mu");
        driver.findElement(By.xpath("//input[@id='sellingrate']")).sendKeys("47");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //String expected="[ "+name+" ] Customer Details Added !";

        ArrayList<String> expected= new ArrayList<>(){{

            add("CUSTOMER MUST CONSIST OF AT LEAST 3 CHARACTERS");
            add("PLEASE ENTER AT LEAST 3 CHARACTERS.");
            add("CUSTOMER ADDRESS MUST BE AT LEAST 3 CHARACTERS LONG");
            add("PLEASE ENTER AT LEAST 3 CHARACTERS.");

        }};

        ArrayList<String>actual= new ArrayList<>();

        try
        {
            List<WebElement> wbList = driver.findElements(By.xpath("//label"));
            actual.add(wbList.get(0).getText());
            actual.add(wbList.get(1).getText());
            actual.add(wbList.get(2).getText());
            actual.add(wbList.get(3).getText());
        }
        catch (Exception e)
        {

        }
        System.out.println("Expected"+expected);
        System.out.println("Actual "+actual);

        Assert.assertEquals(actual,expected,"no error messages");




    }

}
