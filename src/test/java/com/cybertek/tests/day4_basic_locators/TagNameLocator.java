package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement nameInputBox = driver.findElement(By.tagName("input"));
        nameInputBox.sendKeys("Mike Smith");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@smith.com");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        driver.quit();



    }
}
