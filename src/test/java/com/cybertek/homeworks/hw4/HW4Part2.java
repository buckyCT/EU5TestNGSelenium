package com.cybertek.homeworks.hw4;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HW4Part2 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @AfterClass
    public void shutOff(){
        driver.quit();
    }

    @DataProvider(name = "testData")
    public Object[][] createData1() {
        return new Object[][] { {200}, {301}, {404}, {500} };
    }

    @Test(dataProvider = "testData")
    public void tc009_010_011_012(Integer number){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText(""+number+"")).click();

        String expected = "This page returned a " + number + " status code";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actual.contains(expected),"Verify that following message is displayed: '" + expected + "'");

    }
}
