package com.meyoung.day1;

import com.baidu.search.BaiduSearch;
import com.po.page.BaiduPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgDay03 {
    WebDriver driver;
    String pageTitle;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.gecko.driver","C:\\wj\\AutoTestng02\\driversnew\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void chromeTest01() {
        driver.get("http://www.baidu.com");
        //调用百度检索方法
        BaiduSearch.baiduSearch(driver,"selenium");
        pageTitle = driver.getTitle();
        if (pageTitle.contentEquals("selenium_百度搜索")) {
            System.out.println(pageTitle);
        }else{
            System.out.println("error");
        }
    }
    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
