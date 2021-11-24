package com.example.tw3.jira.pages.dropdowns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MoreOptionsDropDown {
    private SelenideElement menu = $x("//aui-dropdown-menu[@id='opsbar-operations_more_drop']");
    private SelenideElement deleteOption = $x("//span[text()='Delete']/..");
    private SelenideElement subTaskOption = $x("//span[text()='create sub-task']/..");

    public SelenideElement getMenu() {
        return menu;
    }

    public SelenideElement getDeleteOption() {
        return deleteOption;
    }

    public SelenideElement getSubTaskOption() {
        return subTaskOption;
    }
}
