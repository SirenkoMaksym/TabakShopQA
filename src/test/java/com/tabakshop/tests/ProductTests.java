package com.tabakshop.tests;

import com.tabakshop.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.tabakshop.data.Data.*;

public class ProductTests extends TestBase{


    private CatalogPage catalogPage;
    private ProductPage productPage;
    private boolean isLoginRequired = true;
    @BeforeMethod
    public void loginAsRegisteredUser() {
        if (isLoginRequired) {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnSignInLink();

            LoginUserPage loginUserPage = new LoginUserPage(driver);
            loginUserPage.enterEmail(EMAIL_EXAMPLE)
                    .enterExistPassword(PASSWOR_EXAMPLE)
                    .clickOnSignInButton();
        }
    }
    @Test
    public void successfulAdditionOfAProductForARegisteredUser() {
        isLoginRequired = true;

        HomePage homePage = new HomePage(driver);
        homePage.clickOnCatalogButton();
        catalogPage = new CatalogPage(driver);
        productPage = new ProductPage(driver);

        catalogPage
                .clickViewDetails(EXAMPLE_PRODUCT);
        productPage
                .clickAddToCart()
                .verifySuccessMessageAddingToCart(SUCCESS_MESSAGE_ADD_TO_CART);

    }

    @Test
    public void unsuccessfulAdditionOfAProductForAnUnregisteredUser(){
        isLoginRequired = false;
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCatalogButton();
        catalogPage = new CatalogPage(driver);
        productPage = new ProductPage(driver);

        catalogPage
                .clickViewDetails(EXAMPLE_PRODUCT);
        productPage
                .clickAddToCart()
                .verifyUnsuccessMessage(MESSAGEUNREGISTERUSER);

    }
    @Test
    public void verifyBackLinkNavigatesToCatalog() {
        isLoginRequired = true;
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCatalogButton();
        catalogPage = new CatalogPage(driver);
        productPage = new ProductPage(driver);

        catalogPage.clickViewDetails(EXAMPLE_PRODUCT);
        catalogPage = productPage.clickBackLink();
        catalogPage.verifyPageTitle(CATALOG_INSCRIPTION);
    }


}
