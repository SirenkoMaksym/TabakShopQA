/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registrationButton;

    public RegistrationPage clickOnRegistrationButton() {
        click(registrationButton);
        return new RegistrationPage(driver);
    }

    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    public LoginUserPage clickOnSignInLink() {
        click(signInLink);
        return new LoginUserPage(driver);
    }
}
