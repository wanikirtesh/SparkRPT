package com.sbn.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    public static WebDriver getDriver(String browser){
        if(driver == null){
            switch (browser.toLowerCase()){
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    driver = new ChromeDriver();
            }
        }
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
