package Popups;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class MultipleWindowsDemo {

    @Test

    public void myMultipleWindowsDemo() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
       // driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://www.facebook.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://gmail.com");

        //driver.switchTo().newWindow(WindowType.TAB);
        //driver.get("http://asianpaints.com");

        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(0));

        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.quit();
    }

}
