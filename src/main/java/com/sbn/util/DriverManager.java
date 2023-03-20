package com.sbn.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    private static String remoteWebdriverUrl = "http://localhost:4444";
    public static WebDriver getDriver(String browser) throws MalformedURLException {
        DesiredCapabilities option =new DesiredCapabilities();
        if(driver == null){
            switch (browser.toLowerCase()){
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    //firefoxOptions.addArguments("--headless");
                    driver = new RemoteWebDriver(new URL(remoteWebdriverUrl),firefoxOptions);
                    break;
                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless","true");
                   // chromeOptions.setHeadless(true);
                    driver = new RemoteWebDriver(new URL(remoteWebdriverUrl),chromeOptions);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
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
