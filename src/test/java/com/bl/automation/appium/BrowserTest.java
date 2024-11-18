package com.bl.automation.appium;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;



public class BrowserTest {
    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.android.quicksearchbox");
        capabilities.setCapability("appActivity","com.android.quicksearchbox.SearchActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }

    @Test(priority=1)
    public void search() throws InterruptedException {
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("com.android.quicksearchbox:id/search_src_text"));
        search.sendKeys("What is appium?");

        WebElement s = driver.findElement(By.id("com.android.quicksearchbox:id/search_go_btn"));
        s.click();


    }

    @Test(priority=2)
    public void SelectOption() throws InterruptedException{

        Thread.sleep(2000);

        WebElement se = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Appium\"]"));
        se.click();



    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
//		driver.quit();
    }

}
