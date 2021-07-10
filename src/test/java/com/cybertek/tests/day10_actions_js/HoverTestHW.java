package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTestHW {
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
    public void hw() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> imgS = driver.findElements(By.tagName("img"));

        Actions actions = new Actions(driver);

        for (int i = 0; i < imgS.size(); i++) {
            Thread.sleep(1000);
            actions.moveToElement(imgS.get(i)).perform();
            String path = "//h5[contains(text(),'user" + (i+1) + "')]";
            Assert.assertTrue(driver.findElement(By.xpath(path)).isDisplayed(),"verify that 'userX' text is displayed");
        }
    }
}
