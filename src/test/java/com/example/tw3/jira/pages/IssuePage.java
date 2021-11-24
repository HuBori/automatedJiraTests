package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IssuePage {
    private SelenideElement detailsSection = $x("//ul[@id='issuedetails']");
    private SelenideElement summaryValue = $x("//h1[@id='summary-val']");
    private SelenideElement projectNameValue = $x("//a[@id='project-name-val']");
    private SelenideElement typeValue = $x("//span[@id='type-val']");
    private SelenideElement reporterValue = $x("//span[@id='issue_summary_reporter_" + System.getenv("username") + "']");
    private SelenideElement moreBtn = $x("//a[@id='opsbar-operations_more']");
    private SelenideElement cantViewIssueMessage = $x("//span[@class='error-image error-image-canNotBeViewed']");


    public SelenideElement getDetailsSection() {
        return detailsSection;
    }

    public SelenideElement getSummaryValue() {
        return summaryValue;
    }

    public SelenideElement getProjectNameValue() {
        return projectNameValue;
    }

    public SelenideElement getTypeValue() {
        return typeValue;
    }

    /** only use if you set an environment variable 'user'! (It's different from 'username') */
    public SelenideElement getReporterValue() {
        return reporterValue;
    }

    public SelenideElement getMoreBtn() {
        return moreBtn;
    }

    public SelenideElement getCantViewIssueMessage() {
        return cantViewIssueMessage;
    }

}
