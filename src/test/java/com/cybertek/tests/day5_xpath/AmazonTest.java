package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        String input = "selenium";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(input);

        //click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        String xpathOfInput = "//span[.='\""+input+"\"']";
        String result1 = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
        String result2 = driver.findElement(By.xpath(xpathOfInput)).getText();
        
        String actual = result1+" "+result2;
        String expected = "results for \"" + input + "\"";

        if(actual.contains(expected)){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
