package com.cybertek.homeworks.hw_day23;

import com.cybertek.pages.CalendarEventViewPage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

        String totalOfRecordsString = calendarEventsPage.totalOfRecordsWE.getText().split(" ")[2];

        int records = Integer.parseInt(totalOfRecordsString);
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

    @Test
    public void tc006() throws InterruptedException {
        extentLogger = report.createTest("TC006 Testers meeting event Test");

        loginAndNavToModule();
        extentLogger.info("Login as Store Manager");
        extentLogger.info("Navigate to ==> Activities -> Calendar Events");

        calendarEventsPage.filterBtn.click();
        extentLogger.info("Click Filter");

        calendarEventsPage.getFilterSelector("Start").click();
        extentLogger.info("Click Start Date filter");

        Select selectStartBetween = new Select(calendarEventsPage.startBetweenSELECT);
        selectStartBetween.selectByVisibleText("later than");
        extentLogger.info("Click 'between' Dropdown and select 'later than'");

        calendarEventsPage.chooseADateInputBox.sendKeys("Nov 27, 2020", Keys.ENTER);
        extentLogger.info("Type 'Nov 27, 2020' into Choose a date box");

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Thread.sleep(2000);

        calendarEventsPage.getFilterSelector("Title").click();
        extentLogger.info("Click Title filter");

        calendarEventsPage.filterInputBox.sendKeys("Testers meeting",Keys.ENTER);
        extentLogger.info("Type 'Testers meeting' into input Box and hit Enter on keyboard");

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        Thread.sleep(5000);

        WebElement x = Driver.get().findElement(By.xpath("//tbody/tr/td[text()='Testers meeting']"));
        x.click();
        extentLogger.info("Click to Testers meeting event from the table");

        CalendarEventViewPage calendarEventViewPage = new CalendarEventViewPage();

        String actualTitle = calendarEventViewPage.getEventDetail("Title").getText();
        String expectedTitle = "Testers meeting";

        String actualDescription = calendarEventViewPage.getEventDetail("Description").getText();
        String expectedDescription = "This is a a weekly testers meeting";

        String actualStart = calendarEventViewPage.getEventDetail("Start").getText();
        String expectedStart = "Nov 27, 2020, 9:30 AM";

        String actualEnd = calendarEventViewPage.getEventDetail("End").getText();
        String expectedEnd = "Nov 27, 2020, 10:30 AM";

        String actualAllDay = calendarEventViewPage.getEventDetail("All-day event").getText();
        String expectedAllDay = "No";

        String actualCall = calendarEventViewPage.getEventDetail("Call via Hangout").getText();
        String expectedCall = "No";

        String expectedOrganizer = "Stephan Haley";
        String actualOrganizer = Driver.get().findElement(By.xpath("//label[text()='Organizer']/../div/div/div/a")).getText();

        extentLogger.info("Verify all data");

        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualStart,expectedStart);
        Assert.assertEquals(actualEnd,expectedEnd);
        Assert.assertEquals(actualAllDay,expectedAllDay);
        Assert.assertEquals(actualCall,expectedCall);
        Assert.assertTrue(actualOrganizer.contains(expectedOrganizer));

        extentLogger.pass("TC006 Testers meeting event Test");

    }

}
