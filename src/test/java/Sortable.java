import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sortable {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/sortable.php");
    }
    @Test
    public void sortable(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement src=driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-move'])[3]"));
        WebElement target=driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-move'])[2]"));
        Actions action= new Actions(driver);
        action.clickAndHold(src).moveToElement(target).release().build().perform();

    }
}
