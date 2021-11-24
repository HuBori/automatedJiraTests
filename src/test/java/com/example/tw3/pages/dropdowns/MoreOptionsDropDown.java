package com.example.tw3.pages.dropdowns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MoreOptionsDropDown {
    private SelenideElement menu = $x("//aui-dropdown-menu[@id='opsbar-operations_more_drop']");
    private SelenideElement deleteOption = $x("//aui-item-link[@id='delete-issue']");
    private SelenideElement subTaskOption = $x("//aui-item-link[@id='create-subtask']");
    private SelenideElement logWorkOption = $x("//aui-item-link[@id='log-work']");

    public SelenideElement getMenu() {
        return menu;
    }

    public SelenideElement getDeleteOption() {
        return deleteOption;
    }

    public SelenideElement getSubTaskOption() {
        return subTaskOption;
    }

    public SelenideElement getLogWorkOption() {
        return logWorkOption;
    }
}
