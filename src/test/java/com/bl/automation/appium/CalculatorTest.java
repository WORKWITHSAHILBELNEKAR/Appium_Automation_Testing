package com.bl.automation.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        capabilities.setCapability("adbExecTimeout", 120000); // 120 seconds
        capabilities.setCapability("newCommandTimeout", 180); // 3 minutes




        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }

    @Test
    public void Add() throws InterruptedException {
        Thread.sleep(5000);
        WebElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        two.click();
        WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();

        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        plus.click();

        WebElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        one.click();
        WebElement zero = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));
        zero.click();

        WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equal.click();

    }

    @Test
    public void multiplication() {
        WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();
        WebElement multiply = driver.findElement(AppiumBy.accessibilityId("multiply"));
        multiply.click();
        WebElement seven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        seven.click();
        WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equal.click();


    }

    @Test
    public void substraction() {

        WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();
        WebElement minus = driver.findElement(AppiumBy.accessibilityId("minus"));
        minus.click();
        WebElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        two.click();
        WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equal.click();
//		WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));



    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }
}
