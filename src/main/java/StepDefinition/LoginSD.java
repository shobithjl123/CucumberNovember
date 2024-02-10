package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSD {

    public static WebDriver driver;
    @Given("user is on loginpage")
    public void user_is_on_loginpage() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.org/");
    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
         driver.findElement(By.name("submit")).click();
    }
    @Then("user should be redirected to Home page.")
    public void user_should_be_redirected_to_home_page() {
        Assert.assertEquals("this is not dashboard page","POSNIC - Dashboard",driver.getTitle());
    }


    @When("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        driver.findElement(By.id("login-username")).sendKeys("dfdgetr");
        driver.findElement(By.id("login-password")).sendKeys("kddfr");
    }

    @Then("user should get error.")
    public void userShouldGetError() {
        Assert.assertEquals("wrong un and pwd","https://stock.scriptinglogic.org/index.php?msg=Wrong%20Username%20or%20Password&type=error",driver.getCurrentUrl());
    }

    @When("user enters blank username and password")
    public void userEntersBlankUsernameAndPassword() {
        driver.findElement(By.id("login-username")).sendKeys("");
        driver.findElement(By.id("login-password")).sendKeys("");
    }

    @Then("user should get error on the page.")
    public void userShouldGetErrorOnThePage() {
        Assert.assertEquals("blank un and pwd","https://stock.scriptinglogic.org/",driver.getCurrentUrl());
    }

    @When("user enters {string} and {string}")
    public void userEntersValidAnd(String username, String password) {
        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-password")).sendKeys(password);
    }
}
