package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class VerifyConfirmationMessage {

    public static void main(String[] args) {

        String expectedConfirmationMessage = "Your e-mail's been sent!";
        String expectedEmail = "mike@smith.com";

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");

        //verify that email is displayed in the input box
        String actualEmail = emailInputBox.getAttribute("value");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        if(actualConfirmationMessage.getText().equals(expectedConfirmationMessage)
                && actualEmail.equals(expectedEmail)) {
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

        driver.quit();

    }
}
