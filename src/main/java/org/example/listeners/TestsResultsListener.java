package org.example.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.example.DriverHolder;
import org.example.TestsRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;

public class TestsResultsListener implements ITestListener {


    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        driver= DriverHolder.availableDrivers.get(0);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf("Test is failed");
       byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
       InputStream is = new ByteArrayInputStream(screenshotAs);
       Allure.addAttachment("image","image/png", is,".png");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.printf("Test is onTestSkipped");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test is onTestSuccess");
    }
 /*   @Attachment(type = "image/png")
    private  byte[] screenshot()  {
        String screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return Base64.getDecoder().decode(screenshotAs);
    }*/
}
