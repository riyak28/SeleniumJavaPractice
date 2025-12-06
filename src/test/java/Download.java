import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Download {
    WebDriver driver;            //declaration

    @BeforeClass
    public void setup() {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        driver = new ChromeDriver();   //initialization
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

    }
    @Test
    public void upload_File(){
        driver.findElement(By.xpath("//button[contains(text(),'Elements')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),' Upload and Download')]")).click();
   WebElement upload_Button=driver.findElement(By.xpath("//input[@type='file']"));
   upload_Button.sendKeys("C:\\Users\\Admins\\Pictures\\download.jpg");
       System.out.println(upload_Button.getAttribute("value"));
if (upload_Button.getAttribute("value").equals("C:\\fakepath\\download.jpg"))
    //if (upload_Button.getAttribute("value").contains("download.jpg"))

{

    System.out.println("Test Case Pass" +upload_Button.getAttribute("value"));

}
else{
    System.out.println("Test Case Fail");
}
//        Assert.assertEquals(upload_Button.getAttribute("value"),"C:\\fakepath\\download.jepg","File PAth verification failed");
//        System.out.println("Hi");



    }
    @Test
    public void download_File(){

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
