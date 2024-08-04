package com.tabakshop.tests;

import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.LoginUserPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
@BeforeMethod
    public void precondition(){
    new HomePage(driver).clickOnSignInLink();
}
@Test  // todo сделать таблицу для нескольких пользователей
    public void loginPositive(){
    new LoginUserPage(driver)
            .enterEmail()
            .enterExistPassword()
            .clickOnSignInButton()
            .verifySuccesfullLogin("Logout");

}


}
