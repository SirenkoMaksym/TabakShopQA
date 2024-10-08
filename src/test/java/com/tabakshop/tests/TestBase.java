/*
 * created by max$
 */


package com.tabakshop.tests;


import com.tabakshop.config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class TestBase {
  //  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));
    protected static ApplicationManager app;
    public WebDriver driver;
    Logger logger  = LoggerFactory.getLogger(TestBase.class);
    @Parameters("browser")
    @BeforeMethod
    public void init(String browser) {
        app = new ApplicationManager(browser);
        logger.info("Initializing test with browser: " + browser);
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
