package org.example.stepdefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyStepdefs {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("WebDriver.chrome.driver","C:\\Savitaclasses\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Given("User opens browser and navigate to register page")
    public void user_opens_browser_and_navigate_to_register_page() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");

    }
    @When("User enters First Name,Last Name,User Name,Password")
    public void user_enters_first_name_last_name_user_name_password() {
        driver.findElement(By.id("firstname")).sendKeys("RIYA");
        driver.findElement(By.cssSelector("input[placeholder='lastname']")).sendKeys("KALE");
        driver.findElement(By.id("username")).sendKeys("RIYYA");
        driver.findElement(By.id("password")).sendKeys("India@1234");

    }
    @When("Click on Register Button")
    public void click_on_register_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }
    @Then("User should register successfully")
    public void user_should_register_successfully() {
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,"Selenium Practice - Register","Failed to verify title");
    }

    @When("User enters First Name as {string},Last Name as {string},User Name as {string},Password as {string}")
    public void userEntersFirstNameAsLastNameAsUserNameAsPasswordAs(String FirstName, String LastName, String UserName, String Password) {
        driver.findElement(By.id("firstname")).sendKeys(FirstName);
        driver.findElement(By.cssSelector("input[placeholder='lastname']")).sendKeys(LastName);
        driver.findElement(By.id("username")).sendKeys(UserName);
        driver.findElement(By.id("password")).sendKeys(Password);
    }

    }


