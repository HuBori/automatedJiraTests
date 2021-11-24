package com.example.tw3.jira.pages.screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EditIssueScreen {
    SelenideElement editIssueDialog = $x("//section[@id='edit-issue-dialog']");
    SelenideElement issueSummaryField = $x("//input[@id='summary']");
    SelenideElement issueUpdateBtn = $x("//input[@id='edit-issue-submit']");


    public SelenideElement getEditIssueDialog() {
        return editIssueDialog;
    }

    public SelenideElement getIssueSummaryField() {
        return issueSummaryField;
    }

    public SelenideElement getIssueUpdateBtn() {
        return issueUpdateBtn;
    }
}
