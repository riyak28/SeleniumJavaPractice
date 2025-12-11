package org.example.forms;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Test {
    public static void main(String[]args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver","C:\\Savitaclasses\\chromedriver.exe");
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        WebElement Name =driver.findElement(By.id("name"));
//          Name.sendKeys("RIYA");
//        driver.findElement(By.id("email")).sendKeys("nomail@gmail.com");
      WebElement gender= driver.findElement(By.xpath("//label[text()='Female']/../input"));
//        driver.findElement(By.cssSelector("input[placeholder='Enter Mobile Number']")).sendKeys("9922996144");
       Actions date=new Actions(driver);
      WebElement birthDate =  driver.findElement(By.cssSelector("#dob"));
      Action action = date.moveToElement(birthDate).click(birthDate).sendKeys("11-28-2025").build();
      action.perform();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='RIYA';",Name);
        System.out.println("using driver " + driver.getTitle());
        js.executeScript("arguments[0].click();",gender);
System.out.println(        js.executeScript("return arguments[0].innerText;",Name));
        System.out.println("using getText " + driver.findElement(By.xpath("//label[text()='Music']")).getText());
        System.out.println("using driver " + Name.getAttribute("value"));


        System.out.println("using js "+ js.executeScript( "return document.title;").toString());
//
//        //        driver.findElement(By.cssSelector("input#dob")).sendKeys("01/11/2025");
//        driver.findElement(By.name("subjects")).sendKeys("JAVA");
//        driver.findElement(By.xpath("//label[text()='Music']/preceding-sibling::input")).click();
//        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
//        upload.sendKeys("C:\\Users\\Admins\\Pictures\\Camera Roll");
//        driver.findElement(By.cssSelector("textarea[name='picture']")).sendKeys("Punawale");
//        WebElement State=driver.findElement(By.name("state"));
//Select select = new Select(State);
//select.selectByValue("Rajasthan");
//WebElement city=driver.findElement(By.id("city"));
//Select select1= new Select(city);
//select1.selectByVisibleText("Lucknow");

js.executeScript("window.scrollBy(300,0);");
     //  driver.findElement(By.xpath("//input[@value='Login']")).click();
       Thread.sleep(5000);
       String studentForm= driver.findElement(By.id("email")).getAttribute("class");
       if (studentForm.contains("form-control error"))
       {
           System.out.println("TestPass");
       }
       else {
           System.out.println("TestNotPass");

       }


}}
