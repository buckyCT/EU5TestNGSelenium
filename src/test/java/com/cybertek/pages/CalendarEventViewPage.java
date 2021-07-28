package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarEventViewPage extends BasePage{

    //label[text()='Start']/../div/div

    public WebElement getEventDetail(String nameOfDetail){
        return Driver.get().findElement(By.xpath("//label[text()='" + nameOfDetail + "']/../div/div"));
    }

}
