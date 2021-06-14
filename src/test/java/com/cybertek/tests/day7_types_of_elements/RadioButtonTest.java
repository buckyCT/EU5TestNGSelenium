package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {

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
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        Assert.assertTrue(blueRadioBtn.isSelected(),"verify blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"verify red is NOT selected");

        redRadioBtn.click();

        Assert.assertFalse(blueRadioBtn.isSelected(),"verify blue is NOT selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"verify red is selected");

    }
}
