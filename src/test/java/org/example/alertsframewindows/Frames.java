package org.example.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximize");
        //options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement frame= driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        System.out.println(frame.getText());
        driver.switchTo().defaultContent();
        driver.close();
}}
