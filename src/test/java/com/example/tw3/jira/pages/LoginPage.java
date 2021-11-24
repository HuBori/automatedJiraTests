package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public final String url = "https://jira-auto.codecool.metastage.net/login.jsp";
    SelenideElement usernameField = $x("//input[@id='login-form-username']");
    SelenideElement passwordField = $x("//input[@id='login-form-password']");
    SelenideElement loginForm = $x("//form[@id='login-form']");
    SelenideElement errorMsg = $x("//p[contains(text(),'Sorry, your username and password are incorrect - ')]");
    SelenideElement mustLogInMsg = $x("//p[contains(text(),'You must log in to access this page.')]");

    public SelenideElement getUsernameField() {
        return usernameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getLoginForm() {
        return loginForm;
    }

    public SelenideElement getErrorMsg() {
        return errorMsg;
    }

    public SelenideElement getMustLogInMsg() {
        return mustLogInMsg;
    }
}
