/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminOrdersPage extends BasePage{
    public AdminOrdersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//main/div[1]/div/h2")
    WebElement ordersMessage;
    public void verifyArchivedProductsPage(String text) {
        Assert.assertTrue(shouldHaveText(ordersMessage, text, 3));
    }



}
