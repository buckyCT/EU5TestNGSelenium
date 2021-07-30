package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarEventViewPage extends BasePage{

    public WebElement getEventDetail(String nameOfDetail){
        return Driver.get().findElement(By.xpath("//label[text()='" + nameOfDetail + "']/../div/div"));
    }

    public WebElement getOrganizerDetail(){
        return Driver.get().findElement(By.xpath("//label[text()='Organizer']/../div/div/div/a"));
    }

}
