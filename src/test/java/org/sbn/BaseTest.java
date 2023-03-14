package org.sbn;

import com.sbn.util.DriverManager;
import org.openqa.selenium.WebDriver;

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
    public void initReporting(){

    }

    @AfterSuite
    public void flushReports(){

    }

    @BeforeMethod
    public void createTest() throws MalformedURLException {
        driver = DriverManager.getDriver("firefox");
    }

    @AfterMethod
    public void completeTest(){
        DriverManager.closeDriver();

    }
}
