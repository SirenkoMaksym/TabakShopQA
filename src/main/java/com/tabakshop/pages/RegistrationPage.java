/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Locale;

import static org.testng.AssertJUnit.assertEquals;

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

    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    WebElement registerButton;


    public RegistrationPage clickOnRegistrationButton() {
        moveWithJs(registerButton, 0, 100);
        pause(2000);
        click(registerButton);
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutLink;

    public void verifySuccessfulRegistration(String text) {
        pause(2000);
        moveWithJs(logoutLink, 0, -100);
        Assert.assertTrue(logoutLink.getText().equals(text));
    }

    public void verifyUnsuccessfulRegistrationWithWrongEmail() {
        String validationMessage = inputEmail.getAttribute("validationMessage");
        Assert.assertTrue(!validationMessage.isEmpty());
    }


    @FindBy(tagName = "h2")
    WebElement registrationTitle;


    public RegistrationPage verifySuccessfulRegistrationPage(String text) {
        Assert.assertTrue(registrationTitle.getText().equals(text));
        return this;

    }

    public RegistrationPage enterEmailOne() {
        type(inputEmail, "superTest5@mail.com");
        return this;
    }

    public RegistrationPage enterPasswordOne() {
        type(inputPassword, "SuperPassword1!");
        return this;
    }

    public RegistrationPage enterConfirmPasswordOne() {
        type(inputConfirmPassword, "SuperPassword1!");
        return this;
    }

    //@FindBy(xpath = "div[@class='_formGroup_9xrab_32']//label[contains(text(), 'I am at least 18 years old')]//input[@class='_checkbox_9xrab_44']/n")
    @FindBy(xpath = "//form/div[4]//input[@type='checkbox']")
    WebElement checkBox;

    public RegistrationPage clickOnCheckBox() {
        click(checkBox);
        return this;
    }

    @FindBy(xpath = "//form/div[5]//input[@type='checkbox']")
    WebElement checkBox2;

    public RegistrationPage clickOnCheckBox2() {
        click(checkBox2);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Return to home page')]")
    WebElement confirmButton;

    public HomePage clickOnConfirmButton() {
        pause(1000);
        click(confirmButton);
        return new HomePage(driver);
    }


    public RegistrationPage enterEmailFromPage() {
        Actions actions = new Actions(driver);

        actions.click(inputEmail)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

        return this;
    }

    public RegistrationPage enterPosEmail(String tempEmail, String email) {
        String domain = tempEmail.split("@")[1];
        String newEmail = email + "@" + domain;
        type(inputEmail, newEmail);
        return this;
    }

    public RegistrationPage verifyUncheckBox(String message) {
        String validationMessage = checkBox.getAttribute("validationMessage");
        assertEquals(validationMessage, message);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Passwords do not match')]")
    WebElement errorMessage;

    public void verifyUnsuccessfulRegistration(String message) {
        Assert.assertTrue(shouldHaveText(errorMessage,message,3));
    }
    @FindBy(xpath = "//div[contains(text(),'Password must be in a valid format.')]")
    WebElement errorMessage3;

    public void verifyUnsuccessfulRegistration3(String message) {
        Assert.assertTrue(shouldHaveText(errorMessage3,message,3));
    }

    @FindBy(xpath = "//div[contains(text(),'User already exists. Please try a different email.')]")
    WebElement errorMessage2;

    public void verifyUnsuccessfulRegistration2(String message) {
        Assert.assertTrue(shouldHaveText(errorMessage2,message,3));
    }

    public void verifyUnsuccessfulRegistrationWithWrongPassword() {
        String validationMessage = inputPassword.getAttribute("validationMessage");
        Assert.assertTrue(!validationMessage.isEmpty());
    }

    public void verifyUnsuccessfulRegistrationWithWrongConfirmPassword() {
        String validationMessage = inputConfirmPassword.getAttribute("validationMessage");
        Assert.assertTrue(!validationMessage.isEmpty());
    }
}
