package com.example.tw3.utility;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.IssuePage;
import com.example.tw3.pages.dropdowns.IssueType;
import com.example.tw3.pages.dropdowns.MoreOptionsDropDown;
import com.example.tw3.pages.dropdowns.Project;
import com.example.tw3.pages.screens.CreateIssueScreen;
import com.example.tw3.pages.screens.DeleteIssueScreen;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class CreateIssueUtility {
    private final DashBoardPage dashBoardPage = new DashBoardPage();
    private final CreateIssueScreen createIssueScreen = new CreateIssueScreen();
    private final IssuePage issuePage = new IssuePage();

    private WebDriverWait wait;
    private String issueUrl;

    public void openScreen() {
        dashBoardPage.getCreateBtn().click();
    }

    public boolean createScreenIsVisible() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(createIssueScreen.getScreen()));
        // I separated the two conditions so that it would be easier to debug
        if (!createIssueScreen.getScreen().isDisplayed()) {
            return createIssueScreen.getScreen().isDisplayed();
        }
        return createIssueScreen.getCreateBtn().isDisplayed();
    }

    public void fillForm(Project project, IssueType issueType, String summary) {
        fillField(createIssueScreen.getProjectField(), project.getFullNameWithKey());
        fillField(createIssueScreen.getIssueTypeField(), issueType.name());
        fillField(createIssueScreen.getSummaryField(), summary);
    }

    public void fillField(SelenideElement field, String value) {
        field.click();
        int textSize = Objects.requireNonNull(field.getValue()).length();
        for (int i = 0; i < textSize; i++) {
            field.sendKeys(Keys.BACK_SPACE);
        }
        field.sendKeys(value);
        field.sendKeys(Keys.ENTER);
    }

    public boolean validateInForm(Project project, IssueType issueType, String summary) {
        if(!Objects.equals(createIssueScreen.getProjectField().getValue(), project.getFullNameWithKey())) { return false; }
        if(!Objects.equals(createIssueScreen.getIssueTypeField().getValue(), issueType.name())) { return false; }
        return Objects.equals(createIssueScreen.getSummaryField().getValue(), summary);
    }

    public void createIssueAndOpenPage() {
        createIssueScreen.getCreateBtn().click();
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(createIssueScreen.getIssueLink()));
        createIssueScreen.getIssueLink().click();
        wait.until(ExpectedConditions.visibilityOf(issuePage.getDetailsSection()));
        issueUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public boolean validateIssuePage(Project project, IssueType type, String summary) {
        String projectResult = issuePage.getProjectNameValue().getText();
        String typeResult = issuePage.getTypeValue().getText();
        String summaryResult = issuePage.getSummaryValue().getText();
        System.out.println(projectResult+" "+typeResult+" "+summaryResult);
        if (!projectResult.equals(project.getFullName())) { return false; }
        if (!typeResult.equals(type.name())) { return false; }
        if (!summaryResult.equals(summary)) { return false; }
        return issuePage.getReporterValue().getText().equals(System.getenv("user"));
    }

    public boolean validateIssuePage(String summary, String url) {
        open(url);
        String summaryResult = issuePage.getSummaryValue().getText();
        return summaryResult.equals(summary);
    }

    public void deleteIssue() {
        wait.until(ExpectedConditions.visibilityOf(issuePage.getMoreBtn()));
        issuePage.getMoreBtn().click();
        MoreOptionsDropDown more = new MoreOptionsDropDown();
        while (!more.getDeleteOption().isDisplayed()) {
            more.getMenu().sendKeys(Keys.DOWN);
        }
        more.getDeleteOption().click();
        DeleteIssueScreen delete = new DeleteIssueScreen();
        wait.until(ExpectedConditions.visibilityOf(delete.getDialog()));
        wait.until(ExpectedConditions.visibilityOf(delete.getMessage()));
        delete.getDeleteBtn().click();
    }

    public boolean validateDeleted() {
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        open(issueUrl);
        return issuePage.getCantViewIssueMessage().isDisplayed();
    }

    public void closeCreateIssueScreen() {
        createIssueScreen.getCancelBtn().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }

    public boolean validateSubTaskOptionPresent() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        issuePage.getMoreBtn().click();
        MoreOptionsDropDown more = new MoreOptionsDropDown();
        wait.until(ExpectedConditions.visibilityOf(more.getLogWorkOption()));
        return more.getSubTaskOption().isDisplayed();
    }

    public boolean validateFormData(String projectName, String type){
        openScreen();
        fillForm(projectName, type);
        System.out.println(createIssueScreen.getProjectField().getValue());
        System.out.println(createIssueScreen.getIssueTypeField().getValue());
        return Objects.equals(createIssueScreen.getProjectField().getValue(), projectName) &&
                Objects.equals(createIssueScreen.getIssueTypeField().getValue(), type);
    }

    private void fillForm(String projectName, String issueType) {
        fillField(createIssueScreen.getProjectField(), projectName);
        fillField(createIssueScreen.getIssueTypeField(), issueType);
        createIssueScreen.getCreateIssueHeader().click();
    }
}
