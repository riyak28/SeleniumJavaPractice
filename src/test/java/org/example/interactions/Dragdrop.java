package org.example.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dragdrop {

    WebDriver driver;            //declaration

    @BeforeClass
    public void setup() {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        driver = new ChromeDriver();   //initialization
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
        //driver.findElement(By.xpath("//button[contains(text(),'Interaction')]")).click();

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void droppable() {
        driver.findElement(By.xpath("//a[contains(text(),' Droppable')]")).click();
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).build().perform();
        String verifyText = drop.getText();
        if (verifyText.contains("Dropped!")) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test is fail");
        }

    }

    @Test
    public void draggable() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
        driver.findElement(By.xpath("//a[contains(text(),'Dragabble')]"));
        WebElement drag = driver.findElement(By.id("draggables"));
        drag.click();
        Actions action = new Actions(driver);
        action.moveToElement(drag).dragAndDropBy(drag, 500, 100).build().perform();
        //  action.moveToElement()clickAndHold(drag).release().build().perform();

    }
}
