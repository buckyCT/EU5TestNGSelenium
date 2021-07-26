package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

    public WebElement getCellWithData(String cellData){
        WebElement cell = Driver.get().findElement(By.xpath("//td[contains(text(),'" + cellData + "')]"));
        return cell;
    }

}
