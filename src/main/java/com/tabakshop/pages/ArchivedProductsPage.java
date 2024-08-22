/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//main/div/div/div[2]")
    WebElement archivedProduct;

    public void verifyArchivedProduct(String nameArchivedProduct) {
        Assert.assertTrue(shouldHaveText(archivedProduct, nameArchivedProduct, 3));
    }

    public ArchivedProductsPage clickOnAddToCatalogButton(String nameNewProduct) {
        pause(3000);
        moveWithJsWithoutElement(0,300);
        pause(2000);
        click(driver.findElement(By.xpath("//h5[contains(text(), '" + nameNewProduct
                + "')]/../..//button[@class='addToCatalogButton']")));
        return this;
    }

    @FindBy(xpath = "//ul/li[2]")
    WebElement catalogLink;
    public AdminCatalogPage clickOnCatalogLink() {
        click(catalogLink);
        return new AdminCatalogPage(driver);
    }
}
