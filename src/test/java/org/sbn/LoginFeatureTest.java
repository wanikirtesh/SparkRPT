package org.sbn;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class LoginFeatureTest extends BaseTest{

    @Test(description = "Validate Login with Valid UserName and Password")
    public void validUserPasswordTest(){
        driver.get("https://seleniumbyneeds.github.io/examples/e1/#");
        driver.findElement(By.cssSelector("#user")).sendKeys("admin");
        driver.findElement(By.cssSelector("#password")).sendKeys("pa$$w0rd");
        driver.findElement(By.cssSelector("#login")).click();

    }

    @Test(description = "Validate Login with inValid UserName and Password")
    public void MyClass1SimpleTest2(ITestContext iTestContext){
        driver.get("https://seleniumbyneeds.github.io/examples/e1/#");
        driver.findElement(By.cssSelector("#user")).sendKeys("admin1");
        driver.findElement(By.cssSelector("#password")).sendKeys("pa$$w0rd");
        driver.findElement(By.cssSelector("#login")).click();

    }

}
