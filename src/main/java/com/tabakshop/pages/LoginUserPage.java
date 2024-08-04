package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginUserPage extends BasePage{
    public LoginUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement fieldEmail;


    public LoginUserPage enterEmail() {
        type(fieldEmail,"test1@mail.com");
        return this;
    }

    @FindBy(id = "password")
    WebElement fieldPassword;

    public LoginUserPage enterExistPassword() {
        type(fieldPassword,"Password2222!");
        return this;
    }

    @FindBy(css = "button._button_1ptto_54[type='submit']")
    WebElement signInButton;

    public LoginUserPage clickOnSignInButton() {
        click(signInButton);
        return this;
    }

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public void verifySuccesfullLogin(String text) {
        Assert.assertTrue(logoutLink.getText().equals(text));
    }
}
