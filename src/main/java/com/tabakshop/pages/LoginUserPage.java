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


    public LoginUserPage enterEmail(String emailExample) {
        type(fieldEmail,emailExample);
        return this;
    }

    @FindBy(id = "password")
    WebElement fieldPassword;

    public LoginUserPage enterExistPassword(String passworExample) {
        type(fieldPassword,passworExample);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;

    public LoginUserPage clickOnSignInButton() {
        click(signInButton);
        return this;
    }

    @FindBy(css = "button._navLink_1ngku_35")
    WebElement logoutLink;

    public void verifySuccesfullLogin(String text) {
        Assert.assertTrue(logoutLink.getText().equals(text));
    }
    @FindBy(tagName = "h2")
    WebElement loginTitle;

    public LoginUserPage verifySuccessfulLoginPage(String loginMessage) {
        Assert.assertTrue(loginTitle.getText().equals(loginMessage));
        return this;


    }
    @FindBy(xpath = "//div[contains(text(),'Email or password is incorrect')]")
    WebElement errorMessage;

    public LoginUserPage verifyUnsuccessfulLogin() {
        Assert.assertTrue(errorMessage.isDisplayed());


        return this;
    }
    public LoginUserPage verifyUnsuccessfulLoginWithEmptyEmailField() {
        String script = "return arguments[0].validationMessage;";
        String validationMessage = (String) js.executeScript(script, fieldEmail);

        Assert.assertTrue(validationMessage != null);

        return this;
    }


    public LoginUserPage verifyUnsuccessfulLoginWithEmptyPasswordField() {
        String script = "return arguments[0].validationMessage;";
        String validationMessage = (String) js.executeScript(script, fieldPassword);

        Assert.assertTrue(validationMessage != null);

        return this;
    }
}

