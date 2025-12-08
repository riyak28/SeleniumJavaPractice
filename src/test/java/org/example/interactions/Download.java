package org.example.interactions;

import org.example.utils.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Download {
    WebDriver driver;            //declaration

    @BeforeClass
    public void setup() {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        String downloadPath=System.getProperty("user.dir")+"\\screenshots";
        System.out.println("current direct name = " +downloadPath );
        Map< String,Object> chrome_prefernces=new HashMap<>();
        chrome_prefernces.put("download.default_directory",downloadPath);
        chrome_prefernces.put("download.prompt_download",false);
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs",chrome_prefernces);
        driver = new ChromeDriver(chromeOptions);   //initialization
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");

    }

    @Test
    public void upload_File() throws IOException {
        //driver.findElement(By.xpath("//button[contains(text(),'Elements')]")).click();
        //driver.findElement(By.xpath("//a[contains(text(),' Upload and org.example.interactions.Download')]")).click();
        WebElement upload_Button = driver.findElement(By.xpath("//input[@type='file']"));
        upload_Button.sendKeys("C:\\Users\\Admins\\Pictures\\download.jpg");
        System.out.println(upload_Button.getAttribute("value"));
        if (upload_Button.getAttribute("value").equals("C:\\fakepath\\download.jpg"))
        //if (upload_Button.getAttribute("value").contains("download.jpg"))

        {

            System.out.println("Test Case Pass" + upload_Button.getAttribute("value"));

        } else {
            System.out.println("Test Case Fail");
        }
        Screenshot.captureScreenshot(driver);
//        Assert.assertEquals(upload_Button.getAttribute("value"),"C:\\fakepath\\download.jepg","File PAth verification failed");
//        System.out.println("Hi");


    }

    @Test
    public void download_file() throws InterruptedException {
        Thread.sleep(2000);
        WebElement download_Button = driver.findElement(By.id("downloadButton"));
        download_Button.click();


    }
    @Test
    public void download_File() {

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
