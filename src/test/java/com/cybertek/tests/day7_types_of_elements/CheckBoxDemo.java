package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxDemo {
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
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));

        Assert.assertFalse(checkBox1.isSelected(),"verify box1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify box2 is selected");

        checkBox1.click();
        checkBox2.click();

        Assert.assertTrue(checkBox1.isSelected(),"verify box1 is selected");
        Assert.assertFalse(checkBox2.isSelected(),"verify box2 is NOT selected");

    }

}
