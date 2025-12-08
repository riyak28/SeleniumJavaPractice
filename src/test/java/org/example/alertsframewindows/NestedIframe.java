package org.example.alertsframewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframe {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.tagName("body"));
        System.out.println(left.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.tagName("body"));
        System.out.println(right.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement bottom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
         WebElement bottom=driver.findElement(By.tagName("body"));
        System.out.println(bottom.getText());

        driver.quit();


    }
}
