package com.example.tw3.tests;

import com.example.tw3.utility.BrowseProjectUtility;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
        browseProjectUtility.clickMainTestingProject();
        Assertions.assertTrue(browseProjectUtility.validateProjectKey());
        Assertions.assertTrue(browseProjectUtility.validateProjectName());
    }

    @ParameterizedTest(name = "Test browse {0}")
    @MethodSource("com.example.tw3.utility.BrowseProjectUtility#provideProjectNamesAndKeys")
    public void test(String projectName, String projectKey){
        browseProjectUtility.setProjectUrl(projectKey);
        Assertions.assertTrue(browseProjectUtility.validateProjectKey(projectKey));
        Assertions.assertTrue(browseProjectUtility.validateProjectName(projectName));

    }
}
