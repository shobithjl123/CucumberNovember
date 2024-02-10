package FileUploadandDownload;

import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileDownload {

    //folder location.

    String location=System.getProperty("user.dir") + "\\DownloadFiles";

    String expectedFileName="sample-clouds-400x300.jpg";

    @Before
    //Clean Directory before downloading.
    public void cleanFolder() throws IOException {

        File folder= new File(location);
        FileUtils.cleanDirectory(folder);
    }

    @Test
    public void verifydownloadfile() throws InterruptedException {

        //Initialize Chrome Options
        ChromeOptions options= new ChromeOptions();

        //Set download Path
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",location);
        options.setExperimentalOption("prefs",prefs);


        //Initialize Chrome with Chrome Options.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://samplelib.com/sample-png.html");
        /*Thread.sleep(4000);
        driver.findElement(By.xpath("//span[.='Close']")).click();*/
        driver.findElement(By.xpath("//a[@class='btn btn-outline-primary btn-sm']")).click();
        Thread.sleep(4000);
        Assert.assertTrue(verifyDownloadedfile());
        driver.close();
    }

    //Verify downloaded file
    private boolean verifyDownloadedfile() {
        File folder = new File(location);
        File[] fileList=folder.listFiles();
        boolean isFilePresent = false;
        for (File file:fileList){
            if (file.isFile())
            {
                String fileName= file.getName();
                System.out.println(fileName);
                if (fileName.matches(expectedFileName))
                {
                    isFilePresent=true;
                }
            }
        }
        return isFilePresent;
    }
}
