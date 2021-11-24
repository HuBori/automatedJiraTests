package com.example.tw3.jira.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.jira.pages.LoginPage;
import com.example.tw3.jira.pages.SecondaryLoginPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public interface LoginLogOut {
    LoginPage loginPage = new LoginPage();
    SecondaryLoginPage secondaryLoginPage = new SecondaryLoginPage();

    static void loginPrimary(){
        open(loginPage.url);
        loginPage.getUsernameField().sendKeys(System.getenv("username"));
        loginPage.getPasswordField().sendKeys(System.getenv("password"));
        loginPage.getLoginForm().submit();
    }

    static void loginSecondary(){
        open(secondaryLoginPage.url);
        secondaryLoginPage.getUsernameField().sendKeys(System.getenv("username"));
        secondaryLoginPage.getPasswordField().sendKeys(System.getenv("password"));
        secondaryLoginPage.getLoginForm().submit();
    }

    static void logInWithWrongPassword(String password) {
        open(loginPage.url);
        loginPage.getUsernameField().sendKeys(System.getenv("username"));
        loginPage.getPasswordField().sendKeys(Objects.requireNonNullElse(password, ""));
        // maybe white space isn't tested yet but it send null
        loginPage.getLoginForm().submit();
    }

    static void closeDriver(){
        WebDriverRunner.getWebDriver().close();
    }
}
