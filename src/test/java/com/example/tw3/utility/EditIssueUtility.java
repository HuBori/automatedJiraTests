package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.BrowseIssuePage;
import com.example.tw3.pages.dropdowns.IssueType;
import com.example.tw3.pages.dropdowns.Project;
import com.example.tw3.pages.screens.EditIssueScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    public boolean validateMandatoryField() {
        Project MTP = Project.MTP;
        IssueType bug = IssueType.Bug;
        id = UUID.randomUUID();
        String summary = "issue summary "+id;
        createIssue(MTP,bug,summary);
        issuePage.getEditIssueBtn().click();
        wait.until(ExpectedConditions.visibilityOf(editIssueScreen.getEditIssueDialog()));
        editIssueScreen.getIssueSummaryField().clear();
        editIssueScreen.getIssueUpdateBtn().click();
        wait.until(ExpectedConditions.visibilityOf(editIssueScreen.getErrorMessage()));
        boolean isErrorMsgPresent = editIssueScreen.getErrorMessage().isDisplayed();
        editIssueScreen.getIssueSummaryField().sendKeys(summary);
        editIssueScreen.getIssueUpdateBtn().click();
        return isErrorMsgPresent;
    }

    public boolean validateCancelEdit() {
        Project MTP = Project.MTP;
        IssueType bug = IssueType.Bug;
        id = UUID.randomUUID();
        String summary = "issue summary "+id;
        String editedSummary = "issue summary edited";
        createIssue(MTP,bug,summary);
        issuePage.getEditIssueBtn().click();
        wait.until(ExpectedConditions.visibilityOf(editIssueScreen.getEditIssueDialog()));
        editIssueScreen.getIssueSummaryField().clear();
        editIssueScreen.getIssueSummaryField().sendKeys(editedSummary);
        editIssueScreen.getCancelBtn().click();
        wait.withTimeout(Duration.ofSeconds(2));
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        return issuePage.getIssueSummary().text().equals(summary);

    }
}
