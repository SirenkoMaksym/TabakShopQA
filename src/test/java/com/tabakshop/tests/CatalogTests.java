package com.tabakshop.tests;

import com.tabakshop.pages.CatalogPage;
import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.LoginUserPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.tabakshop.data.Data.*;

public class CatalogTests extends TestBase {

    private CatalogPage catalogPage;


    @BeforeMethod
    public void precondition() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCatalogButton();
        catalogPage = new CatalogPage(driver);
    }

    @Test
    public void verifyCatalogPageLoaded() {
        catalogPage
                .verifyPageTitle(CATALOG_INSCRIPTION);
    }

    @Test
    public void verifyProductSearchFullName() {
        catalogPage
                .searchForProduct(EXAMPLE_PRODUCT)
                .verifySingleProductIsDisplayed(EXAMPLE_PRODUCT);
    }
    @Test
    public void verifyProductSearchPartialName() {
        catalogPage
                .searchForProduct(EXAMPLE_PRODUCT_PARTIAL)
                .verifyProductsDisplayedByPartialName(EXAMPLE_PRODUCT_PARTIAL);
    }
    @Test
    public void verifySortByPriceAscending() {
        catalogPage
                .clickSortByPriceAscending()
                .verifyProductsSortedByPriceAscending();
    }

    @Test
    public void verifySortByPriceDescending() {
        catalogPage
                .clickSortByPriceDescending()
                .verifyProductsSortedByPriceDescending();
    }

    @Test
    public void verifyGoToHomeButton() {
        catalogPage
                .clickGoToHomeButton()
                .verifyHomePageLoaded();
    }
    @Test
    public void verifyViewDetailsButton() {
        catalogPage
                .clickViewDetails(EXAMPLE_PRODUCT)
                .verifyProductDetailsPageLoaded(EXAMPLE_PRODUCT);
    }
//    @Test
//    public void verifyProductImagesDisplayed() {
//        catalogPage
//                .verifyAllProductImagesDisplayed();
//    }




}
