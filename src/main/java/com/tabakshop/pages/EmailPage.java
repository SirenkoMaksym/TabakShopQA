/*
 * created by $
 */


package com.tabakshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.Spliterator;

public class EmailPage extends BasePage {
    public EmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='topmenu']/a[1]")
    WebElement copyLink;

    public EmailPage clickOnCopyEmail() {
        click(copyLink);
        return this;
    }

    @FindBy(xpath = "//div[@id='topmenu']/a[2]")
    WebElement refreshButton;

    public EmailPage clickOnRefreshButton() {
        click(refreshButton);
        return this;
    }

    @FindBy(xpath = "//div[@id='content']//a")
    WebElement confirmLink;

    public EmailPage clickOnConfirmLink() {
        click(confirmLink);
        return this;
    }

    @FindBy(xpath = "//div[@id='messageBody']/div/div/p[2]/a")
    WebElement activateLink;

    public ConfirmActivatePage clickOnActivateLink() {
        click(activateLink);
        return new ConfirmActivatePage(driver);
    }

    @FindBy(id = "login")
    WebElement emailLogin;

    public EmailPage enterEmail() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String email = (String) clipboard.getData(DataFlavor.stringFlavor);
            String emailLog = email.split("@")[0];
            type(emailLogin, emailLog);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    @FindBy(id = "domain")
    WebElement domainInput;

    public EmailPage enterDomain() {
        try {

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String email = (String) clipboard.getData(DataFlavor.stringFlavor);
            String emailDom = email.split("@")[1];
            Select select = new Select(domainInput);
            select.selectByVisibleText("@"+emailDom);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    @FindBy(xpath = "//button")
    WebElement checkButton;

    public EmailPage checkMail() {
        click(checkButton);
        return this;
    }

    public EmailPage enterEmail(String email) {
        type(emailLogin,email);
        return this;
    }

    public EmailPage enterDomain(String tempEmail) {
        String domain = tempEmail.split("@")[1];
        Select select = new Select(domainInput);
        select.selectByVisibleText("@"+domain);
        return this;
    }
}
