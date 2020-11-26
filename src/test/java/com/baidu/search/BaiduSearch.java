package com.baidu.search;

import com.po.page.BaiduPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaiduSearch {
    public static void baiduSearch(WebDriver driver, String text1){
        driver.findElement(BaiduPage.kw).sendKeys(text1);
        driver.findElement(BaiduPage.su).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(BaiduPage.newherf));
    }
}
