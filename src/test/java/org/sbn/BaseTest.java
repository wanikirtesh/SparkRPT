package org.sbn;

import com.sbn.util.DriverManager;
import com.sbn.util.Reporter;
import org.openqa.selenium.WebDriver;

import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Date;

public class BaseTest {
    protected WebDriver driver;
    @BeforeSuite
    public void initReporting(ITestResult iTestResult){
        Reporter.startSuite(iTestResult);

    }

    @AfterSuite
    public void flushReports(){
        Reporter.endSuite();

    }

    @BeforeMethod
    public void createTest() throws MalformedURLException {
        driver = DriverManager.getDriver("firefox");
    }

    @AfterMethod
    public void completeTest(ITestResult testResult){
        Reporter.endTest(testResult);
        DriverManager.closeDriver();

    }
}
