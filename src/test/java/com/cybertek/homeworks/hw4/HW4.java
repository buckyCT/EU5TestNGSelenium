package com.cybertek.homeworks.hw4;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class HW4 {
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
    public void tc001(){
        /*
        Test case #1
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter “wrong_dob” into date of birth input
        box.
        Step 4. Verify that warning message is displayed:
        “The date of birth is not valid”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement expectedMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));

        Assert.assertFalse(expectedMessage.isDisplayed());

        WebElement birthInput = driver.findElement(By.name("birthday"));
        birthInput.sendKeys("wrong_dob");

        Assert.assertTrue(expectedMessage.isDisplayed());

    }

    @Test
    public void tc002(){
        /*
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Verify that following options for
        programming languages are displayed: c++, java,
        JavaScript
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox3")).isDisplayed());

    }

    @Test
    public void tc003(){
        /*
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into first
        name input box.
        Step 4. Verify that warning message is displayed:
        “first name must be more than 2 and less than 64
        characters long”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement expectedMessage = driver.findElement(By.xpath("//small[contains(text(),'first name must be more than')]"));

        Assert.assertFalse(expectedMessage.isDisplayed());

        driver.findElement(By.name("firstname")).sendKeys("a");

        Assert.assertTrue(expectedMessage.isDisplayed());

    }

    @Test
    public void tc004(){
        /*
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into last
        name input box.
        Step 4. Verify that warning message is displayed:
        “The last name must be more than 2 and less than
        64 characters long”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement expectedMessage = driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than')]"));

        Assert.assertFalse(expectedMessage.isDisplayed());

        driver.findElement(By.name("lastname")).sendKeys("a");

        Assert.assertTrue(expectedMessage.isDisplayed());

    }

    @Test
    public void tc005(){
        /*
        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed
registration!”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

        driver.findElement(By.name("firstname")).sendKeys("Mike");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("msmith");
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");
        driver.findElement(By.name("password")).sendKeys("mikesmith");
        driver.findElement(By.name("phone")).sendKeys("571-123-4567");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/1970");

        Select departmentSelect = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        Select jobSelect = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));

        Random rn = new Random();
        //System.out.println("departmentSelect.getOptions() = " + departmentSelect.getOptions().size());

        departmentSelect.selectByIndex(rn.nextInt(9)+1);
        jobSelect.selectByIndex(rn.nextInt(8)+1);

        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        WebElement expectedMessage = driver.findElement(By.xpath("//p[text()=\"You've successfully completed registration!\"]"));
        Assert.assertTrue(expectedMessage.isDisplayed());
    }

    @Test
    public void tc006(){
        driver.get("https://www.tempmailaddress.com/");

        String email = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Mike Smith");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        //INTERNAL SERVER ERROR... TO BE CONTINUED

    }
}
