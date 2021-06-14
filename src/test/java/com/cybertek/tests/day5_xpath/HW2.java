package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));
        System.out.println(homeLink.getText());
        homeLink.click();

        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/forgot_password']")); // also possible to use //a[.='Forgot Password']
        System.out.println(forgotPassword.getText());
        forgotPassword.click();

        WebElement emailText = driver.findElement(By.xpath("//label"));
        System.out.println(emailText.getText());

        WebElement emailInputBox = driver.findElement(By.xpath("//input"));
        emailInputBox.sendKeys("avi@love.com");

        WebElement retreivePasswordButton = driver.findElement(By.xpath("//i[@class]"));
        System.out.println(retreivePasswordButton.getText());
        retreivePasswordButton.click();

        Thread.sleep(3000);
        driver.quit();


    }
}
