package com.cybertek.homeworks.hw2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW2 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException { Thread.sleep(2000); driver.quit(); }

    @Test
    public void tc1() {
        driver.get("http://practice.cybertekschool.com/forgot_password");

        System.out.println( driver.findElement( By.xpath("//a[@href='/']") ).getText() );

        System.out.println( driver.findElement( By.xpath("//h2") ).getText() );

        System.out.println( driver.findElement( By.xpath("//label") ).getText() );

        driver.findElement( By.xpath("//input") ).sendKeys("avi@love.com");

        System.out.println( driver.findElement( By.xpath("//i[@class]") ).getText() );
    }

}
