/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminProductPage extends BasePage {
    public AdminProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[2]")
    WebElement deleteButton;

    public AdminCatalogPage clickOnDeleteProduct() {
        click(deleteButton);
        return new AdminCatalogPage(driver);
    }

    @FindBy(xpath = "//main//button[1]")
    WebElement addToArchiveButton;

    public AdminCatalogPage clickOnAddToArchive() {
        pause(3000);
        click(addToArchiveButton);
        pause(3000);
        return new AdminCatalogPage(driver);
    }
}
