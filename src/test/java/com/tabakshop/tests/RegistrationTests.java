/*
 * created by $
 */


package com.tabakshop.tests;

import com.tabakshop.pages.EmailPage;
import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.RegistrationPage;
import com.tabakshop.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.tabakshop.data.Data.*;

public class RegistrationTests extends TestBase {
    private RegistrationPage registrationPage;
    private EmailPage emailPage;

    @BeforeMethod
    public void precondition() {
        registrationPage = new RegistrationPage(driver);
        emailPage = new EmailPage(driver);
        new HomePage(driver).clickOnRegistrationButton();
    }

    @Test
    public void checkingFunctionalityRegistrationButton() {
        registrationPage
                .verifySuccessfulRegistrationPage(REGISTRATION_MESSAGE);
    }
    @Test(dataProvider = "positiveEmail", dataProviderClass = DataProviders.class)
    public void positiveRegistration(String email) {
        registrationPage
                .enterPosEmail(tempEmail, email)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .clickOnConfirmButton();
        driver.navigate().to(EMAIL_URL);
        emailPage
                .enterEmail(email)
                .enterDomain(tempEmail)
                .checkMail()
                .clickOnRefreshButton()
                .clickOnConfirmLink()
                .clickOnActivateLink()
                .verifyActivateMessage(ACTIVATE_MESSAGE);

    }


    @Test
    public void positiveVerifyAccountActivationVerOne() {
        registrationPage
                .enterEmail(tempEmail)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .clickOnConfirmButton()
                .confirmRegistration(tempEmail);
    }

    @Test
    public void positiveVerifyAccountActivationVerTwo() {
        driver.navigate().to(EMAIL_URL);
        emailPage
                .clickOnCopyEmail();
        driver.navigate().back();
        registrationPage
                .enterEmailFromPage()
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .clickOnConfirmButton();

        driver.navigate().to(EMAIL_URL);
        emailPage
                .enterEmail()
                .enterDomain()
                .checkMail()
                .clickOnRefreshButton()
                .clickOnConfirmLink()
                .clickOnActivateLink()
                .verifyActivateMessage(ACTIVATE_MESSAGE);
    }


    @Test
    public void negativeRegistrationWithoutAgeConfirmation() {
        registrationPage
                .enterEmail(tempEmail)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUncheckBox(CHECKBOX_MESSAGE)
        ;
    }

    @Test(dataProvider = "registrationNegativeEmail", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithWrongEmail(String email) {
        registrationPage
                .enterEmail(email)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistrationWithWrongEmail();
        ;
    }

    @Test
    public void negativeRegistrationWithWrongConfirmPassword() {
        registrationPage
                .enterEmail(tempEmail)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(REGISTRATION_MESSAGE)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration(DO_NOT_MATCH_MESSAGE)
        ;
    }

    @Test
    public void negativeRegistrationWithAlreadyRegisteredUsers() {
        registrationPage
                .enterEmail(EMAIL_EXAMPLE)
                .enterPassword(PASSWOR_EXAMPLE)
                .enterConfirmPassword(PASSWOR_EXAMPLE)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration2(EXISTS_USER_MESSAGE)
        ;
    }

    @Test(dataProvider = "registrationNegativePassword", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithWrongPassword(String password) {
        registrationPage
                .enterEmail(tempEmail)
                .enterPassword(password)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration3(NOT_VALID_PASSWORD_MESSAGE)
        ;
    }

    @Test
    public void negativeRegistrationWithoutEmail() {
        registrationPage
                .enterEmail(EMPTY)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistrationWithWrongEmail()
        ;
    }

    @Test
    public void negativeRegistrationWithoutPassword() {
        registrationPage
                .enterEmail(EMAIL_EXAMPLE)
                .enterPassword(EMPTY)
                .enterConfirmPassword(PASSWORD)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistrationWithWrongPassword()
        ;
    }

    @Test
    public void negativeRegistrationWithoutConfirmPassword() {
        registrationPage
                .enterEmail(EMAIL_EXAMPLE)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(EMPTY)
                .clickOnCheckBox()
                .clickOnCheckBox2()
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistrationWithWrongConfirmPassword()
        ;
    }

}
