package org.example.alertsframewindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alertclass {
    WebDriver driver;            //declaration

    @BeforeClass
    public void setup() {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        driver = new ChromeDriver();   //initialization
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//button[@onclick='showAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void confirmBox() {
         messageValidation("accept", "You pressed OK12");
        messageValidation("dismiss", "You pressed Cancel!");
    }
    public void messageValidation(String action, String message) {
        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = confirmAlert.getText();
        System.out.println("Confirm box text is: " + confirmAlert.getText());
        Assert.assertEquals(alertText, "Press a button!", "Alert assertion failed");

        if (action.equals("accept")) {
            confirmAlert.accept();

        } else {
            confirmAlert.dismiss();
        }
        String result = driver.findElement(By.id("desk")).getText();
        Assert.assertEquals(result, message, "Assertion failed for "+ action);



    }


    @Test
    public void alertWait() {

        driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alertWait = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text is:" + alertWait.getText());
        alertWait.accept();

    }

    @Test
    public void sendKeys() {
        driver.findElement(By.xpath("//button[@onclick='myPromp()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert inputText = wait.until(ExpectedConditions.alertIsPresent());
        inputText.sendKeys("RIYA");
        inputText.accept();

    }

}