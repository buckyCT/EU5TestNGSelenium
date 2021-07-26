package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click Login Button");

//        loginPage.login("user1","somepassword");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");

    }

    @Test
    public void wrongUsernameTest(){

        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        loginPage.login("someusername","UserUser123");
        extentLogger.info("Login with 'Username: someusername - Password: UserUser123'");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/loginQWE");

        extentLogger.pass("Wrong Username Test is Passed");

    }

}
