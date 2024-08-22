package com.tabakshop.tests;

import com.tabakshop.pages.*;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import static com.tabakshop.data.Data.*;

public class CartTests extends TestBase {
    private CatalogPage catalogPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void precondition() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSignInLink();
        LoginUserPage loginUserPage = new LoginUserPage(driver);
        loginUserPage.enterEmail(EMAIL_EXAMPLEUNIQUSER)
                .enterExistPassword(PASSWOR_EXAMPLEUNIQUSER)
                .clickOnSignInButton();

        homePage.clickOnCatalogButton();
        catalogPage = new CatalogPage(driver);
        productPage = new ProductPage(driver);
        catalogPage.clickViewDetails(EXAMPLE_PRODUCT);
        productPage.clickAddToCart();

        cartPage = productPage.goToCart();
        cartPage.verifyCartPageLoaded();
    }
    @Test
    public void verifyProductInCartTest() {
        cartPage.verifyProductInCart(EXAMPLE_PRODUCT);
    }

    @Test
    public void verifyIncreaseQuantityButton() {
        cartPage.adjustQuantityTo(1);
        cartPage.clickIncreaseQuantity();
        cartPage.verifyQuantity(2);

    }

    @Test
    public void verifyDecreaseQuantityButton() {
        cartPage.adjustQuantityTo(2);
        cartPage.clickDecreaseQuantity();
        cartPage.verifyQuantity(1);
    }

    @Test
    public void verifyDeleteButton() {
        cartPage.clickDeleteButton();
        cartPage.verifyCartIsEmpty();
    }

    @Test
    public void verifyClearCartButton() {
        cartPage.clickClearCartButton();
        cartPage.verifyCartIsEmpty();
    }

//    @Test
//    public void verifyProceedToPaymentButton() {
//        cartPage.clickProceedToPaymentButton();
//
//    }

}
