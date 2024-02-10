package ExtentReportsDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ExtentReportsDemo.ForExtentReports.screenshot;

public class LoginDemo {

    ExtentReports reports;

    @BeforeClass
    public void initExtentReport()
    {
        ExtentSparkReporter reporter= new ExtentSparkReporter("Report/report.html");
        reports =  new ExtentReports();
        reports.attachReporter(reporter);
        reporter.config().setDocumentTitle("Stock Management System");
        reporter.config().setReportName("Regression Testing");
        reports.setSystemInfo("Project Title","Stock Management");
        reports.setSystemInfo("Testers Name","Shobith JL");
        reports.setSystemInfo("Developers Name","Santosh KL");
        reports.setSystemInfo("Project DeadLine","20Aug2023");
        reports.setSystemInfo("Client Name","CSX");

    }

    @AfterClass
    public void endReport()
    {
        reports.flush();
    }

    @Test
      public void validLogin() throws IOException {

          ExtentTest test= reports.createTest("Valid login testcase");

          WebDriver driver = new ChromeDriver();
          test.info("Browser opened");

          driver.manage().window().maximize();
          driver.get("https://stock.scriptinglogic.org");
          test.info("URL opened");

          WebElement txtUsername = driver.findElement(By.id("login-username"));
          txtUsername.sendKeys("admin");
          test.info("Username entered");

          WebElement txtPassword = driver.findElement(By.id("login-password"));
          txtPassword.sendKeys("admin");
          test.info("Password entered");

          WebElement btnLogin = driver.findElement(By.name("submit"));
          btnLogin.click();
          test.info("Submit button is clicked.");

          String expected = "POSNIC - Dashboard";
          String actual=driver.getTitle();

          try
          {
              Assert.assertEquals(actual,expected,"This is not login page");
              test.pass("We are on Dashboard page");
          }
          catch (AssertionError e)
          {
              test.fail(e.getMessage());
              test.addScreenCaptureFromPath("./Screenshot/"+screenshot(driver));
          }
      }

    @Test
    public void invalidLogin() throws IOException {

        ExtentTest test= reports.createTest("Invalid login testcase");

        WebDriver driver = new ChromeDriver();
        test.info("Browser opened");

        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");
        test.info("URL opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");
        test.info("Username entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");
        test.info("Password entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();
        test.info("Submit button is clicked.");

        String expected="POSNIC - Login to Control Panel";
        String actual=driver.getTitle();

        try
        {
            Assert.assertEquals(actual,expected,"This is Dashboard page");
            test.pass("We are on login page");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshot/"+screenshot(driver));
        }
    }

    @Test
    public void blankLogin() throws IOException {

        ExtentTest test= reports.createTest("Blank login testcase");

        WebDriver driver = new ChromeDriver();
        test.info("Browser opened");

        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org");
        test.info("URL opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");
        test.info("Username entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");
        test.info("Password entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();
        test.info("Submit button is clicked.");

        String expected="POSNIC - Login to Control Panel";
        String actual=driver.getTitle();

        try
        {
            Assert.assertEquals(actual,expected,"This is Dashboard page");
            test.pass("We are on login page");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshot/"+screenshot(driver));
        }
    }
}
