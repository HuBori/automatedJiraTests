package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseIssuePage {
    public final String preSetIssueUrl = "https://jira-auto.codecool.metastage.net/browse/MTP-1188";
    String customIssueUrl = "https://jira-auto.codecool.metastage.net/browse/";
    SelenideElement issueSummary = $x("//h1[@id='summary-val']");
    SelenideElement issueKey = $x("//a[@id='key-val']");
    SelenideElement issueError = $x("//div[@class='issue-error']");
    private SelenideElement editIssueBtn = $x("//a[@id='edit-issue']");


    public SelenideElement getIssueSummary() {
        return issueSummary;
    }

    public SelenideElement getIssueKey() {
        return issueKey;
    }

    public String getCustomIssueUrl() {
        return customIssueUrl;
    }

    public void setCustomIssueUrl(String issueKey) {
        this.customIssueUrl = customIssueUrl + issueKey;
    }

    public SelenideElement getIssueError() {
        return issueError;
    }

    public SelenideElement getEditIssueBtn() {
        return editIssueBtn;

    }
}
