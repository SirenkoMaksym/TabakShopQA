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
        pause(3000);
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

        Assert.assertTrue(nameFirstProduct.getText().equals(nameProduct));
    }

    @FindBy(xpath = "//input[@name='name']")
    WebElement searchField;

    public AdminCatalogPage enterSearchingProduct(String nameProduct) {
        pause(3000);
        type(searchField, nameProduct);
        return this;
    }

    @FindBy(xpath = "//input[@name='name']/../button")
    WebElement searchButton;

    public AdminCatalogPage clickOnSearchButton() {
        pause(1000);
        click(searchButton);
        return this;
    }

    @FindBy(xpath = "//main/div[2]/div[3]/button")
    WebElement addProductButton;

    public AdminCatalogPage clickOnAddButton() {
        click(addProductButton);
        return this;
    }

    @FindBy(xpath = "//form/div[1]/label[1]/input")
    WebElement fieldNewProduct;

    public AdminCatalogPage enterNameProduct(String nameNewProduct) {
        type(fieldNewProduct, nameNewProduct);
        return this;
    }

    @FindBy(xpath = "//form/div[1]/label[2]/input")
    WebElement fieldNewPrice;

    public AdminCatalogPage enterPrice(Double newPrice) {
        pause(3000);
        typeDouble(fieldNewPrice, newPrice);
        return this;
    }

    @FindBy(xpath = "//form/div[1]/label[3]/input")
    WebElement fieldNewQuantity;

    public AdminCatalogPage enterQuantity(int newQuantity) {
        typeInt(fieldNewQuantity, newQuantity);
        return this;
    }

    @FindBy(xpath = "//form/div[1]/label[4]/input")
    WebElement fieldNewDesc;

    public AdminCatalogPage enterDescription(String newDescription) {
        type(fieldNewDesc, newDescription);
        return this;
    }

    @FindBy(xpath = "//form/div[1]/label[5]/input")
    WebElement fieldCharacter;

    public AdminCatalogPage enterCharacteristics(String newCharacteristics) {
        type(fieldCharacter, newCharacteristics);
        return this;
    }

    @FindBy(xpath = "//form//button[2]")
    WebElement AddProductButton;

    public AdminCatalogPage clickOnAddProduct() {
        moveWithJs(addProductButton, 0, 300);
        pause(1000);
        click(AddProductButton);
        return this;
    }

    public void verifyProduct(String nameNewProduct) {
        pause(2000);
        type(searchField, nameNewProduct);
        click(searchButton);
        Assert.assertEquals(nameFirstProduct.getText(), nameNewProduct);
    }

    @FindBy(xpath = "//main/div[2]/div[4]/div[2]//button")
    WebElement viewDetailsLink;

    public AdminProductPage clickOnViewDetails() {
        pause(2000);
        click(viewDetailsLink);
        return new AdminProductPage(driver);
    }

    public void checkAbsenceProduct(String nameDeleteProduct) {
        pause(2000);
        type(searchField, nameDeleteProduct);
        pause(1000);
        click(searchButton);

        Assert.assertFalse(isElementPresent(nameFirstProduct));
    }

    @FindBy(xpath = "//ul/li[3]")
    WebElement archivedLink;

    public ArchivedProductsPage clickOnArchivedLink() {
        click(archivedLink);
        return new ArchivedProductsPage(driver);
    }
}
