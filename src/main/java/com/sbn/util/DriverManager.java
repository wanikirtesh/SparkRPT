package com.sbn.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    private static String remoteWebdriverUrl = "http://localhost:4444";
    public static WebDriver getDriver(String browser) throws MalformedURLException {
        AbstractDriverOptions option =null;
        if(driver == null){
            switch (browser.toLowerCase()){
                case "firefox":
                    option = new FirefoxOptions();
                    break;
                case "chrome":
                default:
                    option = new ChromeOptions();
            }
        }
        driver = new RemoteWebDriver(new URL(remoteWebdriverUrl),option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        try {
            driver.quit();
            driver = null;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
