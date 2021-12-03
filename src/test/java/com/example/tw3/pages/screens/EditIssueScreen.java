package com.example.tw3.pages.screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EditIssueScreen {
    private final SelenideElement editIssueDialog = $x("//section[@id='edit-issue-dialog']");
    private final SelenideElement issueSummaryField = $x("//input[@id='summary']");
    private final SelenideElement issueUpdateBtn = $x("//input[@id='edit-issue-submit']");
    private final SelenideElement cancelBtn = $x("//button[@class='aui-button aui-button-link cancel']");
    private final SelenideElement errorMessage = $x("//div[contains(text(),'You must specify a summary of the issue.')]");



    public SelenideElement getEditIssueDialog() {
        return editIssueDialog;
    }

    public SelenideElement getIssueSummaryField() {
        return issueSummaryField;
    }

    public SelenideElement getIssueUpdateBtn() {
        return issueUpdateBtn;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public SelenideElement getCancelBtn() {
        return cancelBtn;
    }
}
