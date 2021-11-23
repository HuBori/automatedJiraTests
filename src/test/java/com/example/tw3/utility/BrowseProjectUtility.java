package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.BrowseProjectsPage;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class BrowseProjectUtility {
    WebDriverWait wait;


    BrowseProjectsPage browseProjectsPage = new BrowseProjectsPage();

    public void clickMainTestingProject(){
        open(browseProjectsPage.url);
        browseProjectsPage.getMainTestingProjectLink().click();
    }

    public boolean validateProjectKey(){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectKey().text().equals("MTP");
    }

    public boolean validateProjectKey(String projectKey){
        browseProjectsPage.setProjectKey(projectKey);
        System.out.println(browseProjectsPage.getProjectKey());
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        System.out.println(browseProjectsPage.getProjectKey().text());
        System.out.println(projectKey);
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectKey().text().equals(projectKey);
    }

    public boolean validateProjectName() {
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectTitle()));
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectTitle().text().equals("Main Testing Project");
    }

    public boolean validateProjectName(String projectName) {
        browseProjectsPage.setProjectTitle(projectName);
        System.out.println(browseProjectsPage.getProjectTitle());
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectTitle()));
        System.out.println(browseProjectsPage.getProjectTitle().text());
        System.out.println(projectName);
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectTitle().text().equals(projectName);
    }


    public void setProjectUrl(String key){
        browseProjectsPage.setBrowseUrl(key);
        open(browseProjectsPage.getBrowseUrl());
    }
}
