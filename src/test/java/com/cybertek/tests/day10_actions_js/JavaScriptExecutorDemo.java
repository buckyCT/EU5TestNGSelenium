package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
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
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);
    }

    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].setAttribute('value', '" + "Hey Disabled Input" + "')",inputBox);
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i = 0; i < 10; i++) {
            //Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement subscribeButton = driver.findElement(By.xpath("//button[@data-email-list-signup-btn-input]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",subscribeButton);

        Thread.sleep(3000);

        subscribeButton.click();

    }


}
