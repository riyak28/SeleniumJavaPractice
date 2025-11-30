import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "C:\\Savitaclasses\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximize");
        //options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        WebElement searchText = driver.findElement(By.cssSelector("input[placeholder='Search Amazon.in']"));


        //fluent Wait
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluent.until(webDriver -> searchText);
        searchText.sendKeys("Mobile");

        //explicit wait
        WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(25));
        explicit.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        System.out.println("Total element found" + list.size());
        WebElement result;
        double total = 0;
        String price;
        String name;

        for (int i = 0; i < list.size(); i++) {
            price = list.get(i).getAttribute("innerText");   //out of  number of element will get single element
            name = list.get(i).getText();
            System.out.println("Name :" + name);

            System.out.println(price);

            price = price.replace(",", "");
            try {
                total += Double.parseDouble(price);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total amount=" + total);
        driver.quit();
    }
}





































































