package com.cybertek.homeworks.hw_day23;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.WebElement;
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

        extentLogger.pass("TC001 Options Button Test PASS");
    }

    @Test
    public void tc002(){
        extentLogger = report.createTest("TC002 Page Number Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        extentLogger.info("Verify that page number is equals to \"1\"");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");

        extentLogger.pass("TC002 Page Number Test PASS");
    }

    @Test
    public void tc003(){
        extentLogger = report.createTest("TC003 View Per Page Dropdown Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        extentLogger.info("Verify that view per page number is equals to \"25\"");
//        Assert.assertTrue(calendarEventsPage.viewPerPage.getText().contains("25"),"Verify that view per page number is equals to \"25\"");
        Assert.assertEquals(calendarEventsPage.viewPerPage.getText().trim(),"25");

        extentLogger.pass("TC003 View Per Page Dropdown Test PASS");
    }

    @Test
    public void tc004(){
        extentLogger = report.createTest("TC004 Number of Calendar Events Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        int records = Integer.parseInt(calendarEventsPage.totalOfRecordsString);
        int numberOfRows = calendarEventsPage.getAllRowsOfTableInPage().size();

        extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
        if(records>25){
            Assert.assertEquals(numberOfRows,25);
        }else {
            Assert.assertEquals(numberOfRows,records);
        }

        extentLogger.pass("TC004 Number of Calendar Events Test PASS");
    }

    @Test
    public void tc005(){
        extentLogger = report.createTest("TC005 Checkbox Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        calendarEventsPage.selectAllCheckBox.click();
        extentLogger.info("Click the checkbox which selects all checkboxes");

        extentLogger.info("Verify that all calendar events checkboxes were selected");
        for (WebElement checkBox : calendarEventsPage.getAllRowsCheckBoxes()) {
            Assert.assertTrue(checkBox.isSelected(),"Verify that checkbox was selected");
        }

        extentLogger.pass("TC005 Checkbox Test PASS");
    }

}
