package com.example.tw3.jira.tests;

import com.example.tw3.jira.utility.LoginLogOut;
import com.example.tw3.jira.utility.LoginTestsUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTest {
    LoginTestsUtility loginMethods = new LoginTestsUtility();

    @AfterEach
    public void closeDriver(){
        LoginLogOut.closeDriver();
    }

    @Test
    public void login(){
        LoginLogOut.loginPrimary();
        Assertions.assertTrue(loginMethods.isProfileButtonVisible());
        loginMethods.navigateToUserProfile();
        Assertions.assertTrue(loginMethods.isUserNameSame());
    }
    @Test
    public void secondaryLogin(){
        LoginLogOut.loginSecondary();
        Assertions.assertTrue(loginMethods.isProfileButtonVisible());
        loginMethods.navigateToUserProfile();
        Assertions.assertTrue(loginMethods.isUserNameSame());
    }

    @ParameterizedTest (name = "Test for: {1}")
    @CsvFileSource(resources = "/wrong_passwords.csv", numLinesToSkip = 1, delimiter = ';')
    public void testWrongPassword(String password, String testName){
        LoginLogOut.logInWithWrongPassword(password);
        Assertions.assertTrue(loginMethods.isErrorMessageDisplayed());
        Assertions.assertTrue(loginMethods.profileIsNotVisible());
        LoginLogOut.loginPrimary();
    }
}
