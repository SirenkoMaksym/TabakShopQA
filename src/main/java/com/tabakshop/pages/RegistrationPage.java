/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    WebElement inputName;

    public RegistrationPage enterName(String name) {
        type(inputName, name);
        return this;
    }

    @FindBy()
    WebElement inputEmail;

    public RegistrationPage enterEmail(String email) {
        type(inputName, email);
        return this;
    }

    @FindBy()
    WebElement radioButton;

    public RegistrationPage clickOnYesRadioButton() {
        click(radioButton);
        return this;
    }

    @FindBy()
    WebElement inputPassword;

    public RegistrationPage enterPassword(String password) {
        type(inputPassword, password);
        return this;
    }

    @FindBy()
    WebElement inputConfirmPassword;

    public RegistrationPage enterConfirmPassword(String confirmPassword) {
        type(inputConfirmPassword, confirmPassword);
        return this;
    }

    @FindBy()
    WebElement registrationButton;

    public RegistrationPage clickOnRegistrationButton() {
        click(registrationButton);
        return this;
    }

    public void verifySuccessfulRegistration() {
    }

    public void verifyUnsuccessfulRegistration() {
    }

    public void verifySuccessfulRegistrationPage() {
    }
    @FindBy()
    WebElement radioButtonNo;
    public RegistrationPage clickOnNoRadioButton() {
        click(radioButtonNo);
        return this;
    }

    public void verifyChoiceNo() {
    }
}
