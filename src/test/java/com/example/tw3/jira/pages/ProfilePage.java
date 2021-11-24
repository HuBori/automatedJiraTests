package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    public final String url = "https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa";
    SelenideElement displayedUserName = $x("//dd[@id='up-d-username']");


    public SelenideElement getDisplayedUserName() {
        return displayedUserName;
    }
}
