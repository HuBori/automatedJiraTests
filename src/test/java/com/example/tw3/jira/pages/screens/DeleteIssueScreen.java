package com.example.tw3.jira.pages.screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DeleteIssueScreen {
    private SelenideElement dialog = $x("//div[@id='delete-issue-dialog']");
    private SelenideElement message = $x("//p[text()='Please confirm that you wish to delete this issue.']");
    private SelenideElement deleteBtn = $x("//input[@id='delete-issue-submit']");

    public SelenideElement getDialog() {
        return dialog;
    }

    public SelenideElement getMessage() {
        return message;
    }

    public SelenideElement getDeleteBtn() {
        return deleteBtn;
    }
}
