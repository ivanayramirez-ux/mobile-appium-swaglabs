package com.ivana.mobile.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ivana.mobile.tests.BaseTest;
import com.ivana.mobile.pages.swaglabs.InventoryPage;
import com.ivana.mobile.pages.swaglabs.LoginPage;

public class LoginSmokeTest extends BaseTest {

    @Test(groups = {"smoke", "login"})
    public void standardUserCanLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(
                inventoryPage.isLoaded(),
                "Inventory page should be visible after login"
        );
    }
}
