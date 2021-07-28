package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')][@data-toggle='dropdown']")
    public WebElement optionsBtn;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

}