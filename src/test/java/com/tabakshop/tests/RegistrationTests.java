/*
 * created by $
 */


package com.tabakshop.tests;

import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.RegistrationPage;
import com.tabakshop.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnRegistrationButton();
    }

    @Test
    public void checkingFunctionalityRegistrationButton(){
        new RegistrationPage(driver)
                .verifySuccessfulRegistrationPage(); //TODO Дописать ассерт
    }


    @Test(dataProvider = "registrationPositiveData", dataProviderClass = DataProviders.class)
    public void positiveRegistration(String name, String email, String password, String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifySuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт,
                                                      // добавить удаление после каждого
                                                      // т.к. не будет проходить из-за одинаковых е-мэйлов
                                                      // или изменить е-мэйлы на разные в датаПровайдере
        ;
    }

    @Test(dataProvider = "registrationPositiveSmall", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithoutAgeConfirmation(String name,
                                                           String email,
                                                           String password,
                                                           String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт
        ;
    }

    @Test(dataProvider = "registrationNegativeEmail", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithWrongEmail(String name,
                                                   String email,
                                                   String password,
                                                   String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт
        ;
    }

    @Test(dataProvider = "registrationNegativePassword", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithWrongPassword(String name, String email,
                                                      String password,
                                                      String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт
        ;
    }

    @Test(dataProvider = "registrationPositiveSmall", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithAlreadyRegisteredUsers(String name, String email,
                                                               String password,
                                                               String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton();
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()
                                                       //todo добавить все локаторы, доделать ассерт
        ;
    }
    @Test(dataProvider = "registrationPositiveSmall", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithWrongConfirmPassword(String name, String email,
                                                      String password,
                                                      String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword("wrongConfirmPassword!")
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()
                                                           //todo добавить все локаторы, доделать ассерт
        ;
    }
    @Test(dataProvider = "registrationNegativeName", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithWrongName(String name, String email,
                                                      String password,
                                                      String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт
        ;
    }
    @Test(dataProvider = "registrationPositiveDataAgain", dataProviderClass = DataProviders.class)
    public void positiveRegistrationAgain(String name, String email, String password, String confirmPassword) {
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifySuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт,
                                                      // добавить удаление после каждого
                                                      // т.к. не будет проходить из-за одинаковых е-мэйлов
                                                      // или изменить е-мэйлы на разные в датаПровайдере
        ;
    }

    @Test
    public void checkingFunctionalityConfirmAgeButton() {
        new RegistrationPage(driver)
                .clickOnYesRadioButton()
                .clickOnNoRadioButton()
                .verifyChoiceNo()       //todo добавить все локаторы, доделать ассерт,

        ;
    }

}
