/*
 * created by max$
 */


package com.tabakshop.tests;


import com.tabakshop.config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init(Method method) {
        logger.info("Start test: " + method.getName());
        driver = app.startTest();
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {
        app.stopTest();
        if (result.isSuccess()){
            logger.info("Test result: PASSED " +result.getMethod().getMethodName());
        }else {
            logger.error("Test result FAILED " + result.getMethod().getMethodName());
        }
        logger.info("************************************************************");
    }
}
