package com.tabakshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h3._catalogTitle_1ug0p_18")
    WebElement pageTitle;

    public CatalogPage verifyPageTitle(String title) {
        Assert.assertTrue(pageTitle.getText().equals(title));
        return this;
    }

    @FindBy(css = "input[name='name']")
    WebElement searchField;
    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchButton;

    public CatalogPage searchForProduct(String nameProduct) {
        type(searchField, nameProduct);
        pause(3000);
        click(searchButton);
        return this;

    }

    @FindBy(xpath = "//div[@class='_cardContainer_1ug0p_124']//h5[contains(@class, '_cardTitle_1vqdh_56')]")
    List<WebElement> productTitles;

    public CatalogPage verifySingleProductIsDisplayed(String exampleProduct) {
        Assert.assertEquals(productTitles.size(), 1);
        Assert.assertEquals(productTitles.get(0).getText(), exampleProduct);
        return this;
    }

    public CatalogPage verifyProductsDisplayedByPartialName(String partialName) {
        pause(3000);

        for (WebElement title : productTitles) {
            Assert.assertTrue(title.getText().toLowerCase().contains(partialName.toLowerCase()));
        }

        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Sort by Price Ascending')]")
    WebElement sortByPriceAscendingButton;


    public CatalogPage clickSortByPriceAscending() {
        pause(3000);
        click(sortByPriceAscendingButton);
        pause(3000);
        return this;
    }

    @FindBy(xpath = "//p[contains(@class, '_cardPrice_1vqdh_64')]")
    List<WebElement> productPrices;

    public CatalogPage verifyProductsSortedByPriceAscending() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(prices, sortedPrices);
        return this;

    }

    private List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "").trim();
            try {
                prices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    @FindBy(xpath = "//button[text()='Sort by Price Descending']")
    WebElement sortByPriceDescendingButton;

    public CatalogPage clickSortByPriceDescending() {
        pause(3000);
        click(sortByPriceDescendingButton);
        pause(3000);
        return this;
    }

    public CatalogPage verifyProductsSortedByPriceDescending() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());
        Assert.assertEquals(prices, sortedPrices);
        return this;

    }

    @FindBy(xpath = "//button[text()='Go to Home']")
    WebElement goToHomeButton;

    public HomePage clickGoToHomeButton() {
        click(goToHomeButton);
        return new HomePage(driver);
    }

    public ProductPage clickViewDetails(String exampleProduct) {
        pause(3000);
        WebElement viewDetailsButtonDynamic = driver.findElement(By.xpath(String.format("//h5[text()='%s']/ancestor::div[contains(@class, '_card_1vqdh_2')]//button[contains(text(),'View Details')]", exampleProduct)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewDetailsButtonDynamic);

        pause(500);
        viewDetailsButtonDynamic.click();
        return new ProductPage(driver);
    }
}
