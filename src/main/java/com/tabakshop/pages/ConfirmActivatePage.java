/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ConfirmActivatePage extends BasePage{
    public ConfirmActivatePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//body")
    WebElement activateMessage;
    public void verifyActivateMessage(String message) {
        Assert.assertTrue(shouldHaveText(activateMessage,message,3));
    }
}
