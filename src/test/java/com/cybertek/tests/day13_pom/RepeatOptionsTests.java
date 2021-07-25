package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class RepeatOptionsTests extends TestBase {

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

//        Assert.assertTrue(!createCalendarEventsPage.weekday.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());

    }

    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
//        List<String> actualList = new ArrayList<>();
//
//        for (WebElement webElement : actualOptions) {
//            actualList.add(webElement.getText());
//        }

        List<String> actualList = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList);

    }

}
