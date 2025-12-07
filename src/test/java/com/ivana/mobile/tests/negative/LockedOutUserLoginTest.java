package com.ivana.mobile.tests.negative;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ivana.mobile.tests.BaseTest;
import com.ivana.mobile.pages.swaglabs.LoginPage;

public class LockedOutUserLoginTest extends BaseTest {

    @Test(groups = {"negative", "login"})
    public void lockedOutUserCannotLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(
                loginPage.isErrorVisible(),
                "Expected an error banner to be visible for locked_out_user"
        );
    }
}
