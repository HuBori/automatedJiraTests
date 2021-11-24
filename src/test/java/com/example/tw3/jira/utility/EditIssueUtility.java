package com.example.tw3.jira.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.jira.pages.BrowseIssuePage;
import com.example.tw3.jira.pages.dropdowns.IssueType;
import com.example.tw3.jira.pages.dropdowns.Project;
import com.example.tw3.jira.pages.screens.EditIssueScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class EditIssueUtility {
    WebDriverWait wait;

    BrowseIssuePage issuePage = new BrowseIssuePage();
    EditIssueScreen editIssueScreen = new EditIssueScreen();
    CreateIssueUtility createIssueUtility = new CreateIssueUtility();
    BrowseIssueUtility browseIssueUtility = new BrowseIssueUtility();
    UUID id;

    private void createIssue(Project MTP, IssueType bug, String summary){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        this.id = UUID.randomUUID();
        createIssueUtility.openScreen();
        createIssueUtility.fillForm(MTP, bug, summary);
        createIssueUtility.createIssueAndOpenPage();
    }

    private void editIssue(String editedSummary) {
        issuePage.getEditIssueBtn().click();
        wait.until(ExpectedConditions.visibilityOf(editIssueScreen.getEditIssueDialog()));
        editIssueScreen.getIssueSummaryField().clear();
        editIssueScreen.getIssueSummaryField().sendKeys(editedSummary);
        editIssueScreen.getIssueUpdateBtn().click();
    }

    public boolean validateEdit() {
        Project MTP = Project.MTP;
        IssueType bug = IssueType.Bug;
        id = UUID.randomUUID();
        String summary = "issue summary "+id;
        String editedSummary = "issue summary edited";
        createIssue(MTP,bug,summary);
        editIssue(editedSummary);
        WebDriverRunner.getWebDriver().get(WebDriverRunner.getWebDriver().getCurrentUrl()); // thanks @Bori! :)
        System.out.println(issuePage.getIssueSummary().text());
        System.out.println(editedSummary);
        return issuePage.getIssueSummary().text().equals(editedSummary);
    }

    public void deleteIssue(){
        createIssueUtility.deleteIssue();
    }


    public boolean isEditable(String issueKey) {
        browseIssueUtility.browseCustomIssue(issueKey);
        return issuePage.getEditIssueBtn().isDisplayed();
    }

    public String expectedUrl(String issueKey) {
        return issuePage.getCustomIssueUrl()+issueKey;

    }

    public String actualUrl(){
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
