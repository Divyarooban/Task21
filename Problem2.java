import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Problem2 {
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
    public void problemTwo() throws InterruptedException {
        //Launch the website
        driver.get("https://the-internet.herokuapp.com/windows");
        //Click on the link
        Actions actions=new Actions(driver);
        WebElement link =driver.findElement(By.xpath("//a[@href='/windows/new']"));
        Actions newwin = new Actions(driver);
        newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(2000);
        //Switch to new window
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        //Verifying the text
        WebElement text=driver.findElement(By.tagName("h3"));
        Assert.assertEquals(text.getText(),"New Window");

        //Verifying the page title
        Assert.assertEquals(driver.getTitle(),"New Window");

        driver.close();
        Thread.sleep(2000);
        //Switching back to main window
        driver.switchTo().window(windowHandles.iterator().next());

        //Verify the page
        Assert.assertEquals(driver.getTitle(),"The Internet");



    }
}
