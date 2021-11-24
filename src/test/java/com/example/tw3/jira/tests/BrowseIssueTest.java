package com.example.tw3.jira.tests;

import com.example.tw3.jira.utility.BrowseIssueUtility;
import com.example.tw3.jira.utility.LoginLogOut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BrowseIssueTest {
    BrowseIssueUtility browseIssueUtility = new BrowseIssueUtility();

    @BeforeAll
    public static void Login(){
        LoginLogOut.loginPrimary();
    }

    @Test
    public void preSetIssueTest(){
        Assertions.assertTrue(browseIssueUtility.validateValues());
    }

    @ParameterizedTest(name = "Test {0} issue of project: {1}")
    @CsvFileSource(resources = "/issues_to_check.csv", numLinesToSkip = 1, delimiter = ';')
    public void testCustomIssue(String issueKey, String projectName){
        Assertions.assertTrue(browseIssueUtility.validateValues(issueKey));
    }
}
