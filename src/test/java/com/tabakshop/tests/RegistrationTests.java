/*
 * created by $
 */


package com.tabakshop.tests;

import com.tabakshop.pages.HomePage;
import com.tabakshop.pages.RegistrationPage;
import com.tabakshop.utils.DataProviders;
import com.tabakshop.utils.TempEmailService;
import org.testng.Assert;
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
                .verifySuccessfulRegistrationPage("Registration"); //TODO Дописать ассерт
    }

    @Test
    public void positiveRegistrationWithoutData(){
        new RegistrationPage(driver)
                .enterEmailOne()
                .enterPasswordOne()
                .enterConfirmPasswordOne()
                .clickOnRegistrationButton()
                .verifySuccessfulRegistration("Logout");
    }

    @Test
    public void massRegistrationWithEmailConfirmation() {
        for (int i = 0; i < 2; i++) {
            String tempEmail = TempEmailService.generateTempEmail();
            new RegistrationPage(driver)
                    .enterEmail(tempEmail)
                    .enterPasswordOne()
                    .enterConfirmPasswordOne()
                    .clickOnCheckBox()
                    .clickOnCheckBo2()
                    .clickOnRegistrationButton()
                    .clickOnConfirmButton()
                    .verifySuccessfulRegistration("Logout");

            confirmRegistration(tempEmail);
        }
    }

    private void confirmRegistration(String email) {
        String verificationLink = TempEmailService.getVerificationLink(email);
        System.out.println("Verification Link: " + verificationLink);

        boolean isActivated = TempEmailService.isAccountActivated(verificationLink);
        Assert.assertTrue(isActivated, "Аккаунт, успешно, активирован");
    }


    // loombook создать объекты. чтобы не было сстрингов. так это по-детски.
    @Test(dataProvider = "registrationPositiveData", dataProviderClass = DataProviders.class)
    public void positiveRegistration(String email, String password, String confirmPassword) {
        new RegistrationPage(driver)
                //     .enterName(name)
                .enterEmail(email)
              //  .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifySuccessfulRegistration("Logout")       //todo добавить все локаторы, доделать ассерт,
                                                      // добавить удаление после каждого
                                                      // т.к. не будет проходить из-за одинаковых е-мэйлов
                                                      // или изменить е-мэйлы на разные в датаПровайдере
                //
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
                // .clickOnYesRadioButton()
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
                //  .clickOnYesRadioButton()
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
               // .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton();
        new RegistrationPage(driver)
                .enterName(name)
                .enterEmail(email)
              //  .clickOnYesRadioButton()
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
            //    .clickOnYesRadioButton()
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
            //    .clickOnYesRadioButton()
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickOnRegistrationButton()
                .verifyUnsuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт
        ;
    }
//    @Test(dataProvider = "registrationPositiveDataAgain", dataProviderClass = DataProviders.class)
//    public void positiveRegistrationAgain(String name, String email, String password, String confirmPassword) {
//        new RegistrationPage(driver)
//                .enterName(name)
//                .enterEmail(email)
//                .clickOnYesRadioButton()
//                .enterPassword(password)
//                .enterConfirmPassword(confirmPassword)
//                .clickOnRegistrationButton()
//                .verifySuccessfulRegistration()       //todo добавить все локаторы, доделать ассерт,
//                                                      // добавить удаление после каждого
//                                                      // т.к. не будет проходить из-за одинаковых е-мэйлов
//                                                      // или изменить е-мэйлы на разные в датаПровайдере
//        ;
//    }

//    @Test
//    public void checkingFunctionalityConfirmAgeButton() {
//        new RegistrationPage(driver)
//               // .clickOnYesRadioButton()
//                .clickOnNoRadioButton()
//                .verifyChoiceNo()       //todo добавить все локаторы, доделать ассерт,
//
//        ;
//    }

}
