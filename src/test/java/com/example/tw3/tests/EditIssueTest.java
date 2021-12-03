package com.example.tw3.tests;

import com.example.tw3.utility.EditIssueUtility;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class EditIssueTest {
    EditIssueUtility editIssueUtility = new EditIssueUtility();

    @BeforeAll
    public static void setUp(){
        LoginLogOut.loginPrimary();
    }

    @AfterAll
    public static void tearDown(){
        LoginLogOut.closeDriver();
    }

    @Test
    public void editTest(){
        Assertions.assertTrue(editIssueUtility.validateEdit());
        editIssueUtility.deleteIssue();
    }

    @Test
    public void editEmptyMandatoryFieldTest(){
        Assertions.assertTrue(editIssueUtility.validateMandatoryField());
        editIssueUtility.deleteIssue();
    }

    @Test
    public void editCancelEdit(){
        Assertions.assertTrue(editIssueUtility.validateCancelEdit());
        editIssueUtility.deleteIssue();
    }



    @ParameterizedTest(name = "Test if {0} is editable")
    @CsvFileSource(resources = "/issues_to_check.csv", numLinesToSkip = 1, delimiter = ';')
    public void editCustomIssues(String issueKey){
        Assertions.assertTrue(editIssueUtility.isEditable(issueKey));
        Assertions.assertEquals(editIssueUtility.expectedUrl(issueKey),editIssueUtility.actualUrl());
    }


}
