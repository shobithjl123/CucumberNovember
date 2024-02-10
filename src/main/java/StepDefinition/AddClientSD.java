package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static StepDefinition.LoginSD.driver;

public class AddClientSD {
    @Given("im on Add client page")
    public void im_on_add_client_page() {
        driver.findElement(By.linkText("Add Customer")).click();


    }
    @When("i enter details on the page")
    public void i_enter_details_on_the_page() {
        driver.findElement(By.name("name")).sendKeys("Shobith");
        driver.findElement(By.name("address")).sendKeys("abcd12");
        driver.findElement(By.name("contact1")).sendKeys("223331");
        driver.findElement(By.name("contact2")).sendKeys("674445");

    }
    @When("i click on Add button")
    public void i_click_on_add_button() {
        driver.findElement(By.name("Submit")).click();

    }
    @Then("User should be added")
    public void user_should_be_added() {
    }
    @When ("^i enter (.+), (.+),(.+),(.+)$")
    public void enterDetails(String name,String address, String contact1,String contact2)
    {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("contact1")).sendKeys(contact1);
        driver.findElement(By.name("contact2")).sendKeys(contact2);
    }



}
