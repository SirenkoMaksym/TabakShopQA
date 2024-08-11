/*
 * created by $
 */


package com.tabakshop.pages;

import com.tabakshop.utils.TempEmailService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='_navLink_1jip9_35'][2]")
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
    public void confirmRegistration(String tempEmail) {
        String verificationLink = TempEmailService.getVerificationLink(tempEmail);
        boolean isActivated = TempEmailService.isAccountActivated(verificationLink);
        Assert.assertTrue(isActivated);
    }
}
