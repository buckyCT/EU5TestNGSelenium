package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement nameInputBox = driver.findElement(By.name("full_name"));
        nameInputBox.sendKeys("Mike Smith");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");

        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));
        signupButton.click();





    }
}
