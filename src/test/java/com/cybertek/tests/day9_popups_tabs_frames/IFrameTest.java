package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {
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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //1st-FRAME
        driver.switchTo().frame("mce_0_ifr");

        WebElement tinymce = driver.findElement(By.cssSelector("#tinymce"));

        tinymce.clear();
        Thread.sleep(1000);
        tinymce.sendKeys("Aviation");
        Thread.sleep(1000);

        //1st-BACK
        driver.switchTo().defaultContent();

        //2nd-FRAME
        driver.switchTo().frame(0);

        tinymce.clear();
        Thread.sleep(1000);
        tinymce.sendKeys("Aviation is");
        Thread.sleep(1000);

        //2nd-BACK
        driver.switchTo().parentFrame();

        //3rd-FRAME
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        tinymce.clear();
        Thread.sleep(1000);
        tinymce.sendKeys("Aviation is love");
        Thread.sleep(1000);

    }
}
