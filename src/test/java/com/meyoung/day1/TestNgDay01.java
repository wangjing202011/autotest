package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDay01 {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\wj\\AutoTestng02\\driversnew\\chromedriver.exe");
        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C:\\wj\\AutoTestng02\\driversnew\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @DataProvider(name = "data01")
    public  Object[][] dataTest01(){
        return new Object[][]{
                {"chrome"},
                {"firefox" }
        };
    }

    @Test(dataProvider = "data01")
    public void chromeTest01(String a,String b)throws InterruptedException{
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}