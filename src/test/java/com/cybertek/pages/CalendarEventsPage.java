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

    @FindBy(xpath = "//input[@type='checkbox'][@data-select]")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterBtn;
    @FindBy(xpath = "//div[@class=\"pull-right grid-toolbar-tools\"]/div/div/a[@title='Filters']")
    public  WebElement filterBtn2;

    @FindBy(xpath = "//input[@type='text'][@name='value']")
    public WebElement filterInputBox;

    @FindBy(xpath = "//button[@data-toggle='dropdown'][@class='btn dropdown-toggle ']")
    public WebElement viewPerPageDropdown;

    @FindBy(xpath = "//span[text()='Title']")
    public WebElement sortWithTitle;

    @FindBy(xpath = "//span[text()='Title']/..")
    public WebElement sortWithTitle2;

    @FindBy(xpath = "//select[@name='start']")
    public WebElement startBetweenSELECT;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement chooseADateInputBox;

    public List<WebElement> viewPerPageDropdownList(){
        return Driver.get().findElements(By.xpath("//a[@class='dropdown-item']"));
    }

    public WebElement getFilterSelector(String name){
        return Driver.get().findElement(By.xpath("//div[contains(text(),'" +name+ "')]"));
    }

    public List<WebElement> getAllRowsCheckBoxes(){
        List<WebElement> elements = Driver.get().findElements(By.xpath("//input[@type='checkbox'][@data-role]"));
        return elements;
    }

    public List<WebElement> getAllRowsOfTableInPage(){
        List<WebElement> elements = Driver.get().findElements(By.xpath("//table/tbody/tr"));
        return elements;
    }

}