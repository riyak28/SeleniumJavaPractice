package org.example.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Window {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximize");
        //options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        String parentWid = driver.getWindowHandle();
        System.out.println("ParentID:" + parentWid);
        clickHere.click();
        for (String window : driver.getWindowHandles()) {
            System.out.println(window);

            if (!window.equals(parentWid)) {
                driver.switchTo().window(window);
            }
        }
        System.out.println(driver.getTitle());
        //driver.close();
        driver.switchTo().window(parentWid);
        System.out.println(driver.getTitle());

    }}
