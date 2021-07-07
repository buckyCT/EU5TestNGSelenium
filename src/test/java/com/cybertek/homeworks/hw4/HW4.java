package com.cybertek.homeworks.hw4;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW4 {
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
    public void tc001(){
        /*
        Test case #1
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter “wrong_dob” into date of birth input
        box.
        Step 4. Verify that warning message is displayed:
        “The date of birth is not valid”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement birthInput = driver.findElement(By.name("birthday"));
        birthInput.sendKeys("wrong_dob");

        WebElement expectedMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));

        Assert.assertTrue(expectedMessage.isDisplayed());

    }

    @Test
    public void tc002(){
        /*
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Verify that following options for
        programming languages are displayed: c++, java,
        JavaScript
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox3")).isDisplayed());

    }
}
