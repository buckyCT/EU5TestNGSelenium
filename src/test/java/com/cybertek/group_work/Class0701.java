package com.cybertek.group_work;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Class0701 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void tc1(){

        driver.get("http://www.seleniumframework.com/Practiceform/");

        String firstTitle = driver.getTitle();

        WebElement newTab = driver.findElement(By.xpath("//button[text()='New Browser Tab']"));
        newTab.click();

        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.")){
                System.out.println("Success!");
                break;
            }
        }

        String secondTitle = driver.getTitle();

        System.out.println(firstTitle + " === " + secondTitle);

    }

    @Test
    public void tc2() throws InterruptedException {
        driver.get("http://www.seleniumframework.com/Practiceform/");

        WebElement alertButton = driver.findElement(By.cssSelector("button#alert"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        WebElement alertButtonTiming = driver.findElement(By.cssSelector("button#timingAlert"));
        alertButtonTiming.click();
        Thread.sleep(5000);

        alert.accept();

    }

    @Test
    public void tc3() throws InterruptedException {
        driver.get("http://www.seleniumframework.com/Practiceform/");

        WebElement color2 = driver.findElement(By.cssSelector("#doubleClick"));

        String firstAtt = color2.getAttribute("style");

        Actions actions = new Actions(driver);
        actions.doubleClick(color2).perform();

        String secondAtt = color2.getAttribute("style");

        Assert.assertTrue(secondAtt.contains("color: orange"),"verify that second change color button clicked twice and color changed to orange");

    }

    @Test
    public void tc4() throws InterruptedException {
        driver.get("http://www.seleniumframework.com/Practiceform/");

        WebElement dragFrom = driver.findElement(By.cssSelector("#draga"));
        //System.out.println(dragFrom.getText());
        WebElement dragTo = driver.findElement(By.cssSelector("#dragb"));
        //System.out.println(dragTo.getText());

        Actions actions = new Actions(driver);

        actions.dragAndDrop( dragFrom,dragTo ).build().perform();

    }

}
