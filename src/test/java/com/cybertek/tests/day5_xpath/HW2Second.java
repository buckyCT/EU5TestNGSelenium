package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HW2Second {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        System.out.println( driver.findElement( By.xpath("//a[@href='/']") ).getText() );

        System.out.println( driver.findElement( By.xpath("//h2") ).getText() );

        System.out.println( driver.findElement( By.xpath("//label") ).getText() );

        driver.findElement( By.xpath("//input") ).sendKeys("avi@love.com");

        System.out.println( driver.findElement( By.xpath("//i[@class]") ).getText() );

        Thread.sleep(3000);
        driver.quit();

    }
}
