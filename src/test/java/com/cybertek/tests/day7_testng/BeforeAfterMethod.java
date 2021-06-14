package com.cybertek.tests.day7_testng;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BeforeAfterMethod {

    public void test1(){
        System.out.println("First test case");
    }

    @BeforeMethod
    public void a(){
    }
    @AfterMethod
    public void b(){
    }
    @BeforeClass
    public void c(){
    }
    @AfterClass
    public void d(){
    }

}
