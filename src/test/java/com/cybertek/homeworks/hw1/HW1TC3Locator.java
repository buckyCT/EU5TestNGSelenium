package com.cybertek.homeworks.hw1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)'
 */
public class HW1TC3Locator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://en.wikipedia.org");

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        driver.findElement(By.xpath("//a[@href='/wiki/Selenium_(software)']")).click();

        System.out.println(driver.getCurrentUrl());

        String str[] = driver.getCurrentUrl().split("/");

        String actualResult = str[str.length-1];
        String expectedResult = "Selenium_(software)";

        if(actualResult.equals(expectedResult)){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

        Thread.sleep(2000);

        driver.quit();

    }
}
