package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Dunhill')]")
    WebElement productTitle;


    public ProductPage verifyProductDetailsPageLoaded(String expectedProductName) {
        pause(2000);
        String actualProductName = productTitle.getText();
        Assert.assertEquals(actualProductName, expectedProductName);

        return this;
    }
}
