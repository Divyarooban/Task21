import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Problem1 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Launch the webdriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }
    @AfterClass
    public void tearDown(){
        //Close the driver
        driver.quit();
    }
    @Test
    public void problemOne() throws InterruptedException {
        //Launch the Website
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Switch to iframe
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        //Locating the tag 'p'
        WebElement text=driver.findElement(By.tagName("p"));
        text.clear();
        //Entering the data
        text.sendKeys("Hello People");
        Thread.sleep(3000);
    }
}
