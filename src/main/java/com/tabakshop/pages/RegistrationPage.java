/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    WebElement inputName;

    public RegistrationPage enterName(String name) {
        type(inputName, name);
        return this;
    }

    @FindBy(id = "email")
    WebElement inputEmail;

    public RegistrationPage enterEmail(String email) {
        type(inputEmail, email);
        return this;
    }


    @FindBy(id = "password")
    WebElement inputPassword;

    public RegistrationPage enterPassword(String password) {
        type(inputPassword, password);
        return this;
    }

    @FindBy(id = "confirmPassword")
    WebElement inputConfirmPassword;

    public RegistrationPage enterConfirmPassword(String confirmPassword) {
        type(inputConfirmPassword, confirmPassword);
        return this;
    }

    @FindBy(css = "button._button_5smy3_53[type='submit']")
    WebElement registrationButton;

    public RegistrationPage clickOnRegistrationButton() {
        pause(5000);
        click(registrationButton);
        return new RegistrationPage(driver);
    }

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public void verifySuccessfulRegistration(String text) {
        Assert.assertTrue(logoutLink.getText().equals(text));


    }

    public void verifyUnsuccessfulRegistration() {
    }
    @FindBy(tagName = "h2")
    WebElement registrationTitle;


    public RegistrationPage verifySuccessfulRegistrationPage(String text) {
        Assert.assertTrue(registrationTitle.getText().equals(text));
        return this;

    }

    public RegistrationPage enterEmailOne() {
        type(inputEmail,"superTest5@mail.com");
        return this;
    }

    public RegistrationPage enterPasswordOne() {
        type(inputPassword,"SuperPassword1!");
        return this;
    }

    public RegistrationPage enterConfirmPasswordOne() {
        type(inputConfirmPassword,"SuperPassword1!");
        return this;
    }
    //    @FindBy()
//    WebElement radioButton;
//
//    public RegistrationPage clickOnYesRadioButton() {
//        click(radioButton);
//        return this;
//    }
}
//    @FindBy()
//    WebElement radioButtonNo;
//    public RegistrationPage clickOnNoRadioButton() {
//        click(radioButtonNo);
//        return this;
//    }

//    public void verifyChoiceNo() {
//    }
//}
