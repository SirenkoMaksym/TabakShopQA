/*
 * created by $
 */


package com.tabakshop.tests;

import com.tabakshop.pages.AdminCatalogPage;
import com.tabakshop.pages.AdminPanelPage;
import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.LoginUserPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.tabakshop.data.Data.*;

public class AdminPanelTests extends TestBase {
    private AdminPanelPage adminPanelPage;
    private LoginUserPage loginUserPage;

    private AdminCatalogPage adminCatalogPage;

    @BeforeMethod
    public void precondition() {
        loginUserPage = new LoginUserPage(driver);
        adminPanelPage = new AdminPanelPage(driver);
        new HomePage(driver).clickOnSignInLink();
        loginUserPage
                .enterEmail(EMAIL_ADMIN)
                .enterExistPassword(PASSWOR_ADMIN)
                .clickOnSignInButton();
    }

   
    @Test
    public void CheckSortingProductsByPriceAscending(){
        adminPanelPage
                .clickOnCatalogProductsLink()
                .clickOnSortByPriceAscendingButton()
                .verifyPriceFirstSmaller();
    }
    @Test
    public void CheckSortingProductsByPriceDescending(){
        adminPanelPage
                .clickOnCatalogProductsLink()
                .clickOnSortByPriceDescendingButton()
                .verifyPriceFirstBigger();
    }
    @Test
    public void checkFunctionalityProductCatalogLink(){
        adminPanelPage
                .clickOnCatalogProductsLink()
                .verifyProductsCatalogPage(CATALOG_INSCRIPTION);
    }
    @Test
    public void checkFunctionalityArchivedProductLink(){
        adminPanelPage
                .clickOnArchivedProductsLink()
                .verifyArchivedProductsPage(ARCHIVE_INSCRIPTION);
    }
    @Test
    public void checkFunctionalSearchByAdminCatalog(){
        adminPanelPage
                .clickOnCatalogProductsLink()
                .enterSearchingProduct(EXAMPLE_PRODUCT)
                .clickOnSearchButton()
                .verifyFirstProductMatchesSearch(EXAMPLE_PRODUCT);
    }
    @Test
    public void checkFunctionalViewOrdersLink(){
        adminPanelPage
                .clickOnViewOrdersLink()
                .verifyArchivedProductsPage(ORDERS_INSCRIPTION);
    }
    @Test
    public void checkFunctionalSignOutByAdminButton(){
        adminPanelPage
                .clickOnSignOutButton()
                .verifySignInLink(SIGNIN_LINK);
    }
    @Test
    public void addNeuProduct(){
        adminPanelPage
                .clickOnCatalogProductsLink()
                .clickOnAddButton()
                .enterNameProduct(NAME_NEW_PRODUCT)
                .enterPrice(NEW_PRICE)
                .enterQuantity(NEW_QUANTITY)
                .enterDescription(NEW_DESCRIPTION)
                .enterCharacteristics(NEW_CHARACTERISTICS)
                .clickOnAddProduct()
                .verifyProduct(NAME_NEW_PRODUCT)
                ;
    }
   @Test
   public void deleteNeuProduct(){
       adminPanelPage
               .clickOnCatalogProductsLink()
               .enterSearchingProduct(NAME_NEW_PRODUCT)
               .clickOnSearchButton()
               .clickOnViewDetails()
               .clickOnDeleteProduct()
               .checkAbsenceProduct(NAME_NEW_PRODUCT)
       ;
    }
    @Test
    public void addNeuProductToArchive(){
        adminPanelPage
                .clickOnCatalogProductsLink()
                .clickOnAddButton()
                .enterNameProduct(NAME_NEW_PRODUCT)
                .enterPrice(NEW_PRICE)
                .enterQuantity(NEW_QUANTITY)
                .enterDescription(NEW_DESCRIPTION)
                .enterCharacteristics(NEW_CHARACTERISTICS)
                .clickOnAddProduct()
                .enterSearchingProduct(NAME_NEW_PRODUCT)
                .clickOnSearchButton()
                .clickOnViewDetails()
                .clickOnAddToArchive()
                .clickOnArchivedLink()
                .verifyArchivedProduct(NAME_NEW_PRODUCT)
        ;
    }
    @Test
    public void addProductFromArchive(){
        adminPanelPage
                .clickOnArchivedProductsLink()
                .clickOnAddToCatalogButton(NAME_NEW_PRODUCT)
                .clickOnCatalogLink()
                .verifyProduct(NAME_NEW_PRODUCT)
        ;
    }
}
