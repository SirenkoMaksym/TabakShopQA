/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelPage extends BasePage {
    public AdminPanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul/li[2]")
    WebElement catalogLink;

    public AdminCatalogPage clickOnCatalogProductsLink() {
        pause(1000);
        click(catalogLink);
        return new AdminCatalogPage(driver);
    }

    @FindBy(xpath = "//ul/li[3]")
    WebElement archivedLink;

    public ArchivedProductsPage clickOnArchivedProductsLink() {
        click(archivedLink);
        return new ArchivedProductsPage(driver);
    }

    @FindBy(xpath = "//ul/li[4]")
    WebElement ordersLink;

    public AdminOrdersPage clickOnViewOrdersLink() {
        click(ordersLink);
        return new AdminOrdersPage(driver);
    }

    @FindBy(xpath = "//button")
    WebElement signOutButton;

    public LoginUserPage clickOnSignOutButton() {
        pause(1000);
        click(signOutButton);
        return new LoginUserPage(driver);
    }
}
