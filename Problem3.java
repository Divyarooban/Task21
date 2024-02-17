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
import java.util.List;
import java.util.Set;

public class Problem3 {

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
    public void problemThree() throws InterruptedException {

        //Launch the website
        driver.get("http://the-internet.herokuapp.com/nested_frames");


        WebElement iframeTop=driver.findElement(By.xpath("//frame[@name='frame-top']"));
        //Switch to top frame
        driver.switchTo().frame(iframeTop);
        System.out.println(driver.getTitle());
        //Verifying three frames in the Top frame
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        int numberOfFrames = frames.size();
        Assert.assertEquals(numberOfFrames,3);

        //Switching to left frame
        WebElement iframeLeft=driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        Thread.sleep(2000);

        //Verifying the text in the left frame
        WebElement leftframeText=driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        Assert.assertEquals(leftframeText.getText(),"LEFT");

        //Switching back to top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeTop);

        //Switching to Middle frame
        WebElement iframeMiddle=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(iframeMiddle);
        Thread.sleep(2000);

        //Verifying the text in the right frame
        WebElement middleframeText=driver.findElement(By.xpath("//div[@id='content']"));
        Assert.assertEquals(middleframeText.getText(),"MIDDLE");

        //Switching back to top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeTop);

        //Switching to Right frame
        WebElement iframeRight=driver.findElement(By.xpath("//frame[@name='frame-right']"));
        driver.switchTo().frame(iframeRight);
        Thread.sleep(2000);

        //Verifying the text in the right frame
        WebElement rightframeText=driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        Assert.assertEquals(rightframeText.getText(),"RIGHT");

        //Switching back to top frame
        driver.switchTo().defaultContent();
        Thread.sleep(2000);


        //Switching to Bottom frame
        WebElement iframeBottom=driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(iframeBottom);
        Thread.sleep(2000);


        //Verifying the text in the bottom frame
        WebElement bottomframeText=driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        Assert.assertEquals(bottomframeText.getText(),"BOTTOM");

        //Switching back to top frame
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //Verifying the page title
       // Assert.assertEquals(driver.getTitle(),"Frames");



    }
}
