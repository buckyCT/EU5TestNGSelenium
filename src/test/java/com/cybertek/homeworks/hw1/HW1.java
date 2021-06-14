package com.cybertek.homeworks.hw1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void tc1() {
        driver.get("https://ebay.com");

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@id='gh-ac']")); //xpath practice
        searchInputBox.sendKeys("iphone");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        searchButton.click();

        String result = driver.findElement(By.xpath("//h1")).getText(); //ex. 41,779 results for iphone

        String arr[] = result.split(" ");

        String result2 = arr[0].replace(",","");

        System.out.println(result2);
    }

    @Test
    public void tc2() {
        driver.get("https://ebay.com");

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@name='_nkw']"));
        searchInputBox.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        String title = driver.getTitle(); //ex. Selenium | eBay

        Assert.assertTrue(title.toLowerCase().contains("selenium"),"verify title name contains selenium");
    }

    @Test
    public void tc3(){
        driver.get("https://en.wikipedia.org");

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        driver.findElement(By.xpath("//a[@href='/wiki/Selenium_(software)']")).click();

        //System.out.println(driver.getCurrentUrl());

        String str[] = driver.getCurrentUrl().split("/");

        String actualResult = str[str.length-1];
        String expectedResult = "Selenium_(software)";

        Assert.assertEquals(actualResult,expectedResult);
    }

}
