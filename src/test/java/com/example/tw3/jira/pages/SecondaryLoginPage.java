package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SecondaryLoginPage {
    public final String url = "https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa";
    SelenideElement usernameField = $x("//input[@id='login-form-username']");
    SelenideElement passwordField = $x("//input[@id='login-form-password']");
    SelenideElement loginForm = $x("//form[@id='loginform']");


    public SelenideElement getUsernameField() {
        return usernameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getLoginForm() {
        return loginForm;
    }
}
