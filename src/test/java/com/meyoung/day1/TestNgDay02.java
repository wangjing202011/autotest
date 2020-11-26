package com.meyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDay02 {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.gecko.driver","C:\\wj\\AutoTestng02\\driversnew\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void chromeTest01() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("今日新鲜事");
        driver.findElement(By.id("su")).click();
        //在按钮后加等待，等待内容是新画面的某一个标识。
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content_left']/div[2]/h3/a")));
        //Thread.sleep(10000);
        String pageTitle=driver.getTitle();
        if (pageTitle.contentEquals("今日新鲜事_百度搜索")) {
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
