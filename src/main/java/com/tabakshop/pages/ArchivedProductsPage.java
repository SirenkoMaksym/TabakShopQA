/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ArchivedProductsPage extends BasePage {
    public ArchivedProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//main/div[1]/div[1]/h3")
    WebElement archiveMessage;

    public void verifyArchivedProductsPage(String text) {
        Assert.assertTrue(shouldHaveText(archiveMessage, text, 3));
    }
}
