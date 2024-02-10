package DataProvider;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginDemoExcel {

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
    public Object[][] getData() throws IOException {

        // 1. Read the file.
        FileInputStream fis = new FileInputStream("data/Data.xls");

        // 2.Converting the fileObject in to Workbook Object.
        HSSFWorkbook workBook= new HSSFWorkbook(fis);

        //3.Pick up the sheet.

        HSSFSheet sheet= workBook.getSheet("Sheet1");

        //4 .Count the active Rows.

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][]data= new Object[rowCount][2];

        for (int i=0;i<rowCount;i++)
        {
            HSSFRow row = sheet.getRow(i);
            data[i][0]= row.getCell(0).toString().trim();
            data[i][1]= row.getCell(1).toString().trim();
        }
        return data;



      /*  Object[][]data= new Object[4][2];
        data[0][0]="admin";
        data[0][1]="admin";

        data[1][0]="invalid-1";
        data[1][1]="123123";

        data[2][0]="inalid-2";
        data[2][1]="123123";

        data[3][0]="invalid-3";
        data[3][1]="123123";*/

        //return data;

    }

}
