package com.cybertek.homeworks.hw3;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
TC #1: SeleniumEasy Checkbox Verification – Section 1
1.Open Chrome browser
2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3.Verify “Success – Check box is checked” message is NOT displayed.
4.Click to checkbox under “Single Checkbox Demo” section
5.Verify “Success – Check box is checked” message is displayed.

TC #2: SeleniumEasy Checkbox Verification –Section 2
1.Open Chrome browser
2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3.Verify “Check All” button text is “Check All”
4.Click to “Check All” button
5.Verify all check boxes are checked
6.Verify button text changed to “Uncheck All”
 */
public class HW3 {
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
    public void tc1(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement message = driver.findElement(By.id("txtAge"));
        Assert.assertFalse(message.isDisplayed(),"Verify “Success – Check box is checked” message is NOT displayed.");

        //4.Click to checkbox under “Single Checkbox Demo” section
        driver.findElement(By.id("isAgeSelected")).click();

        Assert.assertTrue(message.isDisplayed(),"Verify “Success – Check box is checked” message is displayed.");

    }

    @Test
    public void tc2(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllBtn = driver.findElement(By.id("check1"));

        //3.Verify “Check All” button text is “Check All”
        Assert.assertEquals(checkAllBtn.getAttribute("value"), "Check All");

        checkAllBtn.click();

        //5.Verify all check boxes are checked
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected());

        //6.Verify button text changed to “Uncheck All”
        Assert.assertEquals(checkAllBtn.getAttribute("value"),"Uncheck All");

    }


}
