/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminCatalogPage extends BasePage {
    public AdminCatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//main/div[2]/div[2]/button[1]")
    WebElement ascendingButton;

    public AdminCatalogPage clickOnSortByPriceAscendingButton() {
        pause(1000);
        click(ascendingButton);
        return this;
    }

    @FindBy(xpath = "//main/div[2]/div[4]/div[2]/div[1]/div[1]/p")
    WebElement firstProduct;
    @FindBy(xpath = "//main/div[2]/div[4]/div[2]/div[2]/div[1]/p")
    WebElement secondProduct;

    public void verifyPriceFirstSmaller() {
        double firstProductPrice = Double.parseDouble(firstProduct.getText().replaceAll("[^\\d.]", ""));
        double secondProductPrice = Double.parseDouble(secondProduct.getText().replaceAll("[^\\d.]", ""));

        Assert.assertTrue(firstProductPrice <= secondProductPrice);
    }

    @FindBy(xpath = "//main/div[2]/div[2]/button[2]")
    WebElement descendingButton;

    public AdminCatalogPage clickOnSortByPriceDescendingButton() {
        pause(2000);
        click(descendingButton);
        return this;
    }

    public void verifyPriceFirstBigger() {
        double firstProductPrice = Double.parseDouble(firstProduct.getText().replaceAll("[^\\d.]", ""));
        double secondProductPrice = Double.parseDouble(secondProduct.getText().replaceAll("[^\\d.]", ""));

        Assert.assertTrue(firstProductPrice >= secondProductPrice);
    }

    @FindBy(xpath = "//main/div[2]/div[4]/h3")
    WebElement textProductCatalog;

    public void verifyProductsCatalogPage(String text) {
        Assert.assertTrue(shouldHaveText(textProductCatalog, text, 3));
    }

    @FindBy(xpath = "//main/div[2]/div[4]/div[2]//h5")
    WebElement nameFirstProduct;

    public void verifyFirstProductMatchesSearch(String nameProduct) {
        System.out.println(nameFirstProduct.getText());
        System.out.println(nameProduct);
        Assert.assertTrue(nameFirstProduct.getText().equals(nameProduct));
    }

    @FindBy(xpath = "//input[@name='name']")
    WebElement searchField;

    public AdminCatalogPage enterSearchingProduct(String nameProduct) {
        pause(1000);
        type(searchField, nameProduct);
        return this;
    }

    @FindBy(xpath = "//input[@name='name']/../button")
    WebElement searchButton;

    public AdminCatalogPage clickOnSearchButton() {
        click(searchButton);
        return this;
    }
}
