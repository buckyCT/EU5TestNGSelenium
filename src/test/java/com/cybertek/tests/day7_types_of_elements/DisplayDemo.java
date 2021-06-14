package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisplayDemo {
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
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        Assert.assertFalse(usernameInputBox.isDisplayed(),"verify input box is NOT displayed");

        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        Thread.sleep(5500);

        Assert.assertTrue(usernameInputBox.isDisplayed(),"verify input box is displayed");

    }
}
