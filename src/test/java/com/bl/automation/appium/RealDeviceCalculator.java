package com.bl.automation.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class RealDeviceCalculator {

    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Realme 7");
        capabilities.setCapability("udid","843lkr1xlbuctozl");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11 RP1A.200720.011");
        capabilities.setCapability("appPackage","com.miui.calculator");
        capabilities.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }

    @Test
    public void addition() throws InterruptedException {
        Thread.sleep(2000);
        WebElement five = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
        five.click();

        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        plus.click();

        WebElement eight = driver.findElement(By.id("com.miui.calculator:id/btn_8_s"));
        eight.click();

        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        equals.click();

    }

    @Test
    public void division() {
        WebElement one = driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
        one.click();
        WebElement five = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
        five.click();

        WebElement divide = driver.findElement(AppiumBy.accessibilityId("divide"));
        divide.click();

        WebElement three = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
        three.click();
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        equals.click();

    }

    @Test
    public void substraction() throws InterruptedException {
        Thread.sleep(1000);
        WebElement five = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
        five.click();

        WebElement minus = driver.findElement(AppiumBy.accessibilityId("minus"));
        minus.click();

        WebElement three = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
        three.click();
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        equals.click();
    }

    @Test
    public void multiply() throws InterruptedException {
        Thread.sleep(1000);
        WebElement five = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
        five.click();

        WebElement multiply = driver.findElement(AppiumBy.accessibilityId("multiply"));
        multiply.click();

        WebElement three = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
        three.click();
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        equals.click();
    }



    @AfterTest
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
