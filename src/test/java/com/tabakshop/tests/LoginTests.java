package com.tabakshop.tests;

import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.LoginUserPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.tabakshop.data.Data.*;

public class LoginTests extends TestBase {
    private LoginUserPage loginUserPage;


    @BeforeMethod
    public void precondition() {
        loginUserPage = new LoginUserPage(driver);
        new HomePage(driver).clickOnSignInLink();
    }

    @Test
    public void checkingFunctionalityRegistrationButton() {
        loginUserPage
                .verifySuccessfulLoginPage(LOGIN_MESSAGE);
    }

    @Test
    public void loginPositiveUser() {
        loginUserPage
                .enterEmail(EMAIL_EXAMPLE)
                .enterExistPassword(PASSWOR_EXAMPLE)
                .clickOnSignInButton()
                .verifySuccesfullLogin(LOGOUT_BUTTON);

    }
    @Test
    public void loginPositiveAdmin() {
        loginUserPage
                .enterEmail(EMAIL_ADMIN)
                .enterExistPassword(PASSWOR_ADMIN)
                .clickOnSignInButton()
                .verifySuccesfullLoginAdmin(ADMIN_GREETING);
    }

    @Test
    public void loginNegativeWithWrongPassword() {
        loginUserPage
                .enterEmail(EMAIL_EXAMPLE)
                .enterExistPassword(NOT_EXIST_PASSWORD)
                .clickOnSignInButton()
                .verifyUnsuccessfulLogin();
    }

    @Test
    public void loginNegativeWithWrongEmail() {
        loginUserPage
                .enterEmail(WRONG_EMAIL_EXAMPLE)
                .enterExistPassword(PASSWOR_EXAMPLE)
                .clickOnSignInButton()
                .verifyUnsuccessfulLogin();
    }

    @Test
    public void loginNegativeEmptyEmailField() {
        loginUserPage
                .enterEmail(EMPTY)
                .enterExistPassword(PASSWOR_EXAMPLE)
                .clickOnSignInButton()
                .verifyUnsuccessfulLoginWithEmptyEmailField();

    }

    @Test
    public void loginNegativeEmptyPasswordField() {
        loginUserPage
                .enterEmail(EMAIL_EXAMPLE)
                .enterExistPassword(EMPTY)
                .clickOnSignInButton()
                .verifyUnsuccessfulLoginWithEmptyPasswordField();

    }


}
