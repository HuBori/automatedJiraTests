package com.example.tw3.jira.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.jira.pages.DashBoardPage;
import com.example.tw3.jira.pages.LoginPage;
import com.example.tw3.jira.pages.ProfilePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestsUtility {
    WebDriverWait wait;



    DashBoardPage dashBoardPage = new DashBoardPage();
    ProfilePage profilePage = new ProfilePage();
    LoginPage loginPage = new LoginPage();



    public boolean isProfileButtonVisible() {
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(dashBoardPage.getProfileBtn()));
        return dashBoardPage.getProfileBtn().isDisplayed();
    }

    public void navigateToUserProfile(){
        WebDriverRunner.getWebDriver().get(profilePage.url);
    }

    public boolean isUserNameSame() {
        wait.until(ExpectedConditions.visibilityOf(profilePage.getDisplayedUserName()));
        return profilePage.getDisplayedUserName().text().equals(System.getenv("username"));
    }

    public boolean isErrorMessageDisplayed(){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
        return loginPage.getErrorMsg().isDisplayed();
    }


    public boolean profileIsNotVisible() {
        navigateToUserProfile();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMustLogInMsg()));
        return loginPage.getMustLogInMsg().isDisplayed();
    }

}
