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
        pause(5000);
        String actualProductName = productTitle.getText();
        Assert.assertEquals(actualProductName, expectedProductName);

        return this;
    }

    @FindBy(xpath = "//button[contains(@class, 'add-to-basket-button')]")
    WebElement buttonAddToCart;

    @FindBy(css = ".added-message-container .added-message")
    WebElement alertMessage;

    public ProductPage clickAddToCart() {
        click(buttonAddToCart);
        pause(1000);
        return this;
    }

    public ProductPage verifyUnsuccessMessage(String expectedNEGMessage) {

        Assert.assertTrue(alertMessage.isDisplayed());
        String actualMessage = alertMessage.getText().trim();
        Assert.assertEquals(actualMessage, expectedNEGMessage);

        return this;
    }

    public ProductPage verifySuccessMessageAddingToCart(String expectedPOSMessage) {
        Assert.assertTrue(alertMessage.isDisplayed());
        String actualMessage = alertMessage.getText().trim();
        Assert.assertEquals(actualMessage, expectedPOSMessage);

        return this;
    }

    @FindBy(xpath = "//a[contains(@class, 'back-link')]")
    WebElement backLink;

    public CatalogPage clickBackLink() {
        click(backLink);
        return new CatalogPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cartLink;

    public CartPage goToCart() {
        click(cartLink);
        return new CartPage(driver);

    }
}
