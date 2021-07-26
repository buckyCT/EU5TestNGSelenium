package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    ExtentReports report;

    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){

        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        htmlReporter = new ExtentHtmlReporter(path);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack Smoke Test");

        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @Test
    public void test1(){

        extentLogger = report.createTest("TC123 Login as Driver");

        extentLogger.info("Open Chrome Browser");
        extentLogger.info("Go to this URL");
        extentLogger.info("Enter driver username password");
        extentLogger.info("Click Login");
        extentLogger.info("Verify");
        extentLogger.pass("TC123 passed");

    }

    @AfterMethod
    public void teardown(){
        //this is when the report is actually created
        report.flush();

    }

}
