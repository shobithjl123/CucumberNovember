package TestNGDemos.AssertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginBlank {

    @Test
    public void loginTest()
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
            List<WebElement> wbList = driver.findElements(By.xpath("//*[@class='error']"));
          //  actual[0]= driver.findElement(By.xpath("//label[@for='login-username'][@class='error']")).getText();
          //  actual[1]= driver.findElement(By.xpath("//label[@for='login-password'][@class='error']")).getText();
            actual[0]=wbList.get(0).getText();
            actual[1]=wbList.get(1).getText();
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

    @Test
    public void loginTest1()
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

        //String[] expected={"PLEASE ENTER A USERNAME","PLEASE PROVIDE A PASSWORD"};
        ArrayList<String>expected= new ArrayList<>();
        expected.add("PLEASE ENTER A USERNAME");
        expected.add("PLEASE PROVIDE A PASSWORD");

        ArrayList<String> actual= new ArrayList<>();

        //String[] actual = new String[2];
        try
        {
            List<WebElement> wbList = driver.findElements(By.xpath("//*[@class='error']"));
            actual.add(wbList.get(0).getText());
            actual.add(wbList.get(1).getText());
        }

        catch (Exception e)
        {

        }

        System.out.println("Expected Result...");
        System.out.println(expected);


        System.out.println("Actual Result...");
        System.out.println(actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");

    }

}
