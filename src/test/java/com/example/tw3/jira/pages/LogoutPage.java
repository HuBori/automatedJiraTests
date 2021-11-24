package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogoutPage {
    public String url = "jira-auto.codecool.metastage.net/secure/Logout!";

    private SelenideElement messageWindow = $x("//strong[text()='You are now logged out. Any automatic login has also been stopped.']");
    private SelenideElement messageWindow1 = $x("//form[@id='confirm-logout']");
    private SelenideElement atlasssianLogo = $x("//div[@id='footer-logo']");
    private SelenideElement altLogOutBtn = $x("//input[@id='confirm-logout-submit']");

    public SelenideElement getMessageWindow() {
        return messageWindow;
    }

    public SelenideElement getMessageWindow1() {
        return messageWindow1;
    }

    public SelenideElement getAtlasssianLogo() {
        return atlasssianLogo;
    }

    public SelenideElement getAltLogOutBtn() {
        return altLogOutBtn;
    }
}
