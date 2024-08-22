package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[contains(text(), 'Your Cart')]")
    WebElement cartTitle;
    public CartPage verifyCartPageLoaded() {
        Assert.assertTrue(cartTitle.isDisplayed());
        return this;
    }

    @FindBy(css = ".goHomeButton")
    WebElement goToHomeButton;
    public CartPage clickGoToHomeButton() {
        clickWithJS(goToHomeButton,0,-200);
        return this;
    }

    @FindBy(xpath = "//div[@class='quantity-control']//button[text()='-']")
    WebElement decreaseQuantityButton;

    public CartPage clickDecreaseQuantity() {
        click(decreaseQuantityButton);
        return this;
    }
    @FindBy(xpath = "//div[@class='quantity-control']//button[text()='+']")
    WebElement increaseQuantityButton;
    public CartPage clickIncreaseQuantity() {
        click(increaseQuantityButton);
        return this;
    }

    @FindBy(css = ".delete-button")
    WebElement deleteButton;
    public CartPage clickDeleteButton() {
        click(deleteButton);
        return this;
    }

    @FindBy(css = ".clear-cart-button")
    public WebElement clearCartButton;

    public void clickClearCartButton() {
        pause(2000);
        moveWithJs(clearCartButton, 0, -100);
        js.executeScript("arguments[0].click();", clearCartButton);
    }
    @FindBy(css = ".proceed-to-payment-button")
    WebElement proceedToPaymentButton;
    public CartPage clickProceedToPaymentButton() {
        click(proceedToPaymentButton);
        return this;
    }

    @FindBy(css = ".cart-footer span")
    WebElement totalPrice;
    public CartPage verifyTotalPrice(String expectedPrice) {
        String actualPrice = totalPrice.getText();
        Assert.assertEquals(actualPrice, expectedPrice);
        return this;
    }

    @FindBy(css = ".item-title")
    WebElement productTitleInCart;

    public CartPage verifyProductInCart(String expectedProductName) {
        String actualProductName = productTitleInCart.getText();
        Assert.assertEquals(actualProductName, expectedProductName);
        return this;
    }

    @FindBy(xpath = "//div[@class='quantity-control']//span")
    WebElement quantitySpan;
    public CartPage verifyQuantity(int expectedQuantity) {
        pause(3000);
        int actualQuantity = Integer.parseInt(quantitySpan.getText());
        Assert.assertEquals(actualQuantity, expectedQuantity);
        return this;
    }





    public CartPage verifyCartIsEmpty() {
        pause(2000);
        Assert.assertFalse(isElementPresent(productTitleInCart));
        return this;
    }


    public CartPage adjustQuantityTo(int targetQuantity) {
        int currentQuantity = getCurrentQuantity();

        while (currentQuantity < targetQuantity) {
            clickIncreaseQuantity();
            currentQuantity++;
        }

        while (currentQuantity > targetQuantity) {
            clickDecreaseQuantity();
            currentQuantity--;
        }

        pause(2000);

        verifyQuantity(targetQuantity);
        return this;
    }

    public int getCurrentQuantity() {
        return Integer.parseInt(quantitySpan.getText().trim());
    }
}
