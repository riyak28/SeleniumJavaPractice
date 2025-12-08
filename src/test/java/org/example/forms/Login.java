package org.example.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
System.setProperty("WebDriver.chrome.driver","C:\\Savitaclasses\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
        driver.findElement(By.cssSelector("input[placeholder='UserName']")).sendKeys("nomail@gmail.com");

    }
}
