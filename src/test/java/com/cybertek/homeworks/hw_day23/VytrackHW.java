package com.cybertek.homeworks.hw_day23;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackHW extends TestBase {

    CalendarEventsPage calendarEventsPage;

    public void loginAndNavToModule(){
        new LoginPage().loginAsStoreManager();
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
    }

    @Test
    public void tc001(){
        extentLogger = report.createTest("TC001 Options Button Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        extentLogger.info("Verify that page subtitle \"Options\" is displayed");
        Assert.assertTrue(calendarEventsPage.optionsBtn.isDisplayed());

        extentLogger.pass("TC001 Options Button Test PASSED");
    }

    @Test
    public void tc002(){
        extentLogger = report.createTest("TC002 Page Number Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        extentLogger.info("Verify that page number is equals to \"1\"");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");

        extentLogger.pass("TC002 Page Number Test PASSED");
    }

}
