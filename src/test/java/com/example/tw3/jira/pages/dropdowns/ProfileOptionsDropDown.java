package com.example.tw3.jira.pages.dropdowns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfileOptionsDropDown {
    SelenideElement profileOption = $x("//a[@id='view_profile']");
    SelenideElement logoutOption = $x("//a[@id='log_out']");


    public SelenideElement getProfileOption() {
        return profileOption;
    }

    public SelenideElement getLogoutOption() { return logoutOption; }
}
