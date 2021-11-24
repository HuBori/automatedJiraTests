package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPage {
    SelenideElement profileBtn = $x("//a[@id='header-details-user-fullname']");
    SelenideElement createBtn = $x("//a[@id='create_link']");


    public SelenideElement getProfileBtn() {
        return profileBtn;
    }

    public SelenideElement getCreateBtn() {
        return createBtn;
    }
}
