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

    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    WebElement registerButton;



    public RegistrationPage clickOnRegistrationButton() {
        moveWithJs(registerButton,0,100);
        pause(2000);
        click(registerButton);
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutLink;

    public void verifySuccessfulRegistration(String text) {
        pause(2000);
        moveWithJs(logoutLink,0,-100);
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
        //@FindBy(xpath = "div[@class='_formGroup_9xrab_32']//label[contains(text(), 'I am at least 18 years old')]//input[@class='_checkbox_9xrab_44']/n")
   @FindBy(xpath = "//form/div[4]//input[@type='checkbox']")
    WebElement checkBox;

    public RegistrationPage clickOnCheckBox() {
        click(checkBox);
        return this;
    }
    @FindBy(xpath = "//form/div[5]//input[@type='checkbox']")
    WebElement checkBox2;

    public RegistrationPage clickOnCheckBo2() {
        click(checkBox2);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Return to home page')]")
    WebElement confirmButton;

    public RegistrationPage clickOnConfirmButton() {
        click(confirmButton);

        return this;
    }
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
