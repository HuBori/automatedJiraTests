package com.example.tw3.jira.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmokeTest {
    private com.example.tw3.jira.tests.LoginTest login = new com.example.tw3.jira.tests.LoginTest();
    private com.example.tw3.jira.tests.LogoutTest logout = new com.example.tw3.jira.tests.LogoutTest();
    private com.example.tw3.jira.tests.BrowseIssueTest browseIssue = new com.example.tw3.jira.tests.BrowseIssueTest();
    private com.example.tw3.jira.tests.BrowseProjectTest browseProject = new com.example.tw3.jira.tests.BrowseProjectTest();
    private com.example.tw3.jira.tests.CreateIssueTest createIssue = new com.example.tw3.jira.tests.CreateIssueTest();
    private com.example.tw3.jira.tests.EditIssueTest editIssue = new com.example.tw3.jira.tests.EditIssueTest();

    @BeforeEach
    public void setUp() {
        logout.login();
    }

    @Test
    public void logout() {
        logout.logout();
        logout.login();
        logout.multiTabLogout();
    }

    @Test
    public void login(){
        logout.logout();
        login.login();
    }

    @Test
    public void browseIssue() {
        browseIssue.preSetIssueTest();
    }

    @Test
    public void browseProject() {
        browseProject.browseProject();
    }

    @Test
    public void createIssue(){
        createIssue.createIssue();
    }

    @Test
    public void editIssue(){
        editIssue.editTest();
    }
}
