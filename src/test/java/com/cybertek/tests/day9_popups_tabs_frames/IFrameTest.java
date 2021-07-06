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

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        WebElement topFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);

        WebElement midFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(midFrame);

        System.out.println(driver.findElement(By.cssSelector("div#content")).getText());

        driver.switchTo().parentFrame();

        WebElement rightFrame = driver.findElement(By.name("frame-right"));
        driver.switchTo().frame(rightFrame);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

}
