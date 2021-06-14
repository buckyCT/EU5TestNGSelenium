package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
Go to Ebay
enter search term
click on search button
print number of results
 */
public class HW1TC1Locator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://ebay.com");

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchInputBox.sendKeys("iphone");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        searchButton.click();

        String result = driver.findElement(By.xpath("//h1")).getText(); //41,779 results for iphone

        String arr[] = result.split(" ");

        String result2 = arr[0].replace(",","");

        System.out.println(result2);

        Thread.sleep(2000);

        driver.quit();

    }
}
