package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        driver.findElement(By.id("file-upload"))
                .sendKeys(System.getProperty("user.dir")
                        + "/src/test/resources/textfile.txt");

        driver.findElement(By.id("file-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed() && driver.findElement(By.id("uploaded-files")).isDisplayed());

    }
}
