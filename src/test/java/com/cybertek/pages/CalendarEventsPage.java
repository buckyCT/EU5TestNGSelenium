package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')][@data-toggle='dropdown']")
    public WebElement optionsBtn;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//div[@class='btn-group']/button")
    public WebElement viewPerPage;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement totalOfRecordsWE;
    public String totalOfRecordsString = totalOfRecordsWE.getText().split(" ")[2];

    @FindBy(xpath = "//input[@type='checkbox'][@data-select]")
    public WebElement selectAllCheckBox;

    public List<WebElement> getAllRowsCheckBoxes(){
        List<WebElement> elements = Driver.get().findElements(By.xpath("//input[@type='checkbox'][@data-role]"));
        return elements;
    }

    public List<WebElement> getAllRowsOfTableInPage(){
        List<WebElement> elements = Driver.get().findElements(By.xpath("//table/tbody/tr"));
        return elements;
    }

}