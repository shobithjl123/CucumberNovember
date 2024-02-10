package com.shobith;

import TestNGDemos.Demo2.OpenCloseBrowser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ExtentReportsDemo.ExtentReportListener.initExtentReportObject;
import static ExtentReportsDemo.ForExtentReports.screenshot;
import static TestNGDemos.Demo2.OpenCloseBrowser.driver;

public class ListenerExtentReport extends OpenCloseBrowser implements ITestListener {

    ExtentReports extent;
    ExtentTest test;
    public void onTestStart(ITestResult result) {
        /*if (extent==null)
        extent= initExtentReportObject();*/
        test=extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("test is passed");
    }

    public void onTestFailure(ITestResult result) {
        //test.fail("test is failed");
        test.info("the test is failed.");
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshot/"+screenshot(driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        //test.pass("test is skipped");
        test.skip("test is skipped.");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        if (extent==null)
            extent= initExtentReportObject();
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
