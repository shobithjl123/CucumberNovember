package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;

public class UserRegistration {

    WebDriver driver;

    @Given("user is in registration page")
    public void user_is_in_registration_page() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/Shobith.html");
    }

    @When("clicks on Register button")
    public void clicks_on_register_button() {
     driver.findElement(By.className("registerbtn")).click();
    }
    @Then("user should be added")
    public void user_should_be_added() {

    }

    @When("user enters below data")
    public void userEntersBelowData(DataTable dataTable) {
        List<List<String>> dataTableLists = dataTable.asLists();
        driver.findElement(By.id("email")).sendKeys(dataTableLists.get(0).get(0));
        driver.findElement(By.id("psw")).sendKeys(dataTableLists.get(0).get(1));
        driver.findElement(By.id("psw-repeat")).sendKeys(dataTableLists.get(0).get(2));
    }

   // @When ("^i enter (.+), (.+),(.+),(.+)$")
    //public void enterDetails()
   // {


   // }
}
