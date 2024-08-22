package com.tabakshop.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class ApplicationManager {
    String browser;

    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser){
        this.browser = browser;
    }

    public WebDriver startTest() {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser != null &&
                !browser.equalsIgnoreCase("chrome") &&
                !browser.equalsIgnoreCase("firefox") &&
                !browser.equalsIgnoreCase("edge")) {
            throw new IllegalArgumentException("Browser entered is not correct");
        }

        driver = new EventFiringDecorator(new com.tabakshop.utils.MyListener()).decorate(driver);


        driver.manage().window().maximize();
        //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  ждет загрузку всех элементов страницы.. время любое можно ставить
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://smoke-shop-68y5q.ondigitalocean.app/");
        return driver;
    }

    public void stopTest() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}