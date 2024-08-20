/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }
    public void click(WebElement element) {
        element.click();
    }
    public void clickWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + " , " + y +")");
        click(element);
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void moveWithJs(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + " , " + y +")");

    } public void moveWithJsWithoutElement(int x, int y) {
        js.executeScript("window.scrollBy(" + x + " , " + y +")");

    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public void typeDouble(WebElement element, Double number) {
        if (number != null) {
            click(element);
            element.clear();
            element.sendKeys(number.toString());
        }
    }
    public void typeInt(WebElement element, int number) {
            click(element);
            element.clear();
            element.sendKeys(String.valueOf(number));
    }
    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
