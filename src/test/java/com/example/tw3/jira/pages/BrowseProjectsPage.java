package com.example.tw3.jira.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseProjectsPage {
    public final String url = "https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa";
    String browseUrl;
    SelenideElement mainTestingProjectLink = $x("//a[contains(@original-title, 'Main Testing Project')]");
    SelenideElement projectTitle;
    SelenideElement MTPprojectTitle = $x("//a[contains(text(), 'Main Testing Project')]");
    SelenideElement projectKey = $x("//dd[contains(text(), 'MTP')]");
    String projectKeyXpath = "//dd[contains(text(), 'MTP')]";

    public SelenideElement getMainTestingProjectLink() {
        return mainTestingProjectLink;
    }

    public SelenideElement getProjectTitle() {
        return projectTitle;
    }

    public SelenideElement getProjectKey() {
        return projectKey;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = $x("//a[contains(text(),'"+projectTitle+"' )]");
    }

    public void setProjectKey(String key) {
        this.projectKey = $x("//dd[contains(text(), '"+key+"')]");
    }

    public String getBrowseUrl() {
        return browseUrl;
    }

    public void setBrowseUrl(String key) {
        this.browseUrl = "https://jira-auto.codecool.metastage.net/projects/"+key+"/summary";
    }

    public String getProjectKeyXpath() {
        return projectKeyXpath;
    }

    public SelenideElement getMTPprojectTitle() {
        return MTPprojectTitle;
    }
}
