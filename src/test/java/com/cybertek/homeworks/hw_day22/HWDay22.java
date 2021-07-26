package com.cybertek.homeworks.hw_day22;

import com.cybertek.pages.ContactInformationPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HWDay22 extends TestBase {
    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
    @Test
    public void test1(){

        extentLogger = report.createTest("Contact Information Test");

        String email = "mbrackstone9@example.com";
        String fullName = "Mariam Brackstone";
        String phoneNumber = "+18982323434";

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsSalesManager();
        extentLogger.info("Login as Sales Manager");

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Customers","Contacts");
        extentLogger.info("Navigate to Customers -> Contacts");

        ContactsPage contactsPage = new ContactsPage();

        contactsPage.waitUntilLoaderScreenDisappear();

        WebElement cell = contactsPage.getCellWithData(email);

        cell.click();
        extentLogger.info("Click: " + email);

        ContactInformationPage contactInformationPage = new ContactInformationPage();

        contactInformationPage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals(contactInformationPage.userName.getText(),fullName);
        extentLogger.info("Verify full name is: " + fullName);

        Assert.assertEquals(contactInformationPage.email.getText(),email);
        extentLogger.info("Verify email is: " + email);

        Assert.assertEquals(contactInformationPage.phoneNumber.getText(),phoneNumber);
        extentLogger.info("Verify phone number is: " + phoneNumber);

        extentLogger.pass("Contact Information Test PASS");

    }
}
