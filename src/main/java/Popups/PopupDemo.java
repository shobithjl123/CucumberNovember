package Popups;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PopupDemo {

    @Test

    public void myPopupTest()
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.asianpaints.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement element = driver.findElement(By.xpath("//iframe[contains(@class,'__st_preview_frame')]"));
        driver.switchTo().frame(element);
        driver.findElement(By.xpath("//input[@type='button']")).click();

    }

}
