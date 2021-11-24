package com.example.tw3.jira.tests;

import com.example.tw3.jira.utility.BrowseProjectUtility;
import com.example.tw3.jira.utility.LoginLogOut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BrowseProjectTest {

    BrowseProjectUtility browseProjectUtility = new BrowseProjectUtility();

    @BeforeAll
    public static void login(){
        LoginLogOut.loginPrimary();
    }

    @AfterAll
    static void quitDriver(){
        LoginLogOut.closeDriver();
    }

    @Test
    public void browseProject(){
        browseProjectUtility.navigateToMainTestingProjectSummary();
        Assertions.assertTrue(browseProjectUtility.validateProjectKey());
        Assertions.assertTrue(browseProjectUtility.validateProjectName());
    }

    @ParameterizedTest(name = "Test browse {0}")
    @CsvFileSource(resources = "/projects.csv", numLinesToSkip = 1, delimiter = ';')
    public void browseCustomProjects(String projectName, String projectKey){
        browseProjectUtility.setProjectUrl(projectKey);
        Assertions.assertTrue(browseProjectUtility.validateProjectKey(projectKey));
        Assertions.assertTrue(browseProjectUtility.validateProjectName(projectName));

    }
}
