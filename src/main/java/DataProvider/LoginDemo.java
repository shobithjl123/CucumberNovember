package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDemo {

    //Commiting the LoginDemo file to Repository.

    WebDriver driver;
   /* @BeforeMethod

    public void openBrowser()
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get("https://stock.scriptinglogic.org");
    }*/
    @Test(dataProvider = "getData")
    public void loginTest1(String username,String password)
    {
    /*  WebDriver driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://stock.scriptinglogic.org");*/

        //driver.get("https://stock.scriptinglogic.org");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");
        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys(password);

        WebElement btnLogin= driver.findElement(By.name("submit"));
        btnLogin.click();
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][]data= new Object[4][2];
        data[0][0]="admin";
        data[0][1]="admin";

        data[1][0]="invalid-1";
        data[1][1]="123123";

        data[2][0]="inalid-2";
        data[2][1]="123123";

        data[3][0]="invalid-3";
        data[3][1]="123123";

        return data;

    }

}
