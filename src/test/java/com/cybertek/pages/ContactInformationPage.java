package com.cybertek.pages;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage extends BasePage {

    @FindBy(className = "phone")
    public WebElement phoneNumber;

    @FindBy(className = "email")
    public WebElement email;

    @FindBy(className = "user-name")
    public WebElement userName;

}
