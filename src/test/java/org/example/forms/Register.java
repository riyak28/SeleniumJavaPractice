package org.example.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
public static void main(String[]args)
{
    System.setProperty("WebDriver.chrome.driver","C:\\Savitaclasses\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
    driver.findElement(By.id("firstname")).sendKeys("RIYA");
    driver.findElement(By.cssSelector("input[placeholder='lastname']")).sendKeys("KALE");
    driver.findElement(By.id("username")).sendKeys("RIYYA");
    driver.findElement(By.id("password")).sendKeys("India@1234");


}


}
