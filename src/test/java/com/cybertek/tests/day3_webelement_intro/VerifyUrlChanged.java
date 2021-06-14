package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        emailInputBox.sendKeys("mike@smith.com");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

        driver.quit();

    }
}
