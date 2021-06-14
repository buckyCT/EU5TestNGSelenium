package com.cybertek.homeworks.hw1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Go to Ebay
search Selenium
click on search button
verify title contains Selenium
 */
public class HW1TC2Locator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://ebay.com");

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@name='_nkw']"));
        searchInputBox.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        String title = driver.getTitle(); //Selenium | eBay

        if(title.contains("Selenium")){
            System.out.println("PASS!");
        }else {
            System.out.println("FAIL!");
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
