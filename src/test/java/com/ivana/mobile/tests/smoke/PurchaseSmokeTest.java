package com.ivana.mobile.tests.smoke;

import com.ivana.mobile.pages.swaglabs.CartPage;
import com.ivana.mobile.pages.swaglabs.CheckoutCompletePage;
import com.ivana.mobile.pages.swaglabs.CheckoutStepOnePage;
import com.ivana.mobile.pages.swaglabs.CheckoutStepTwoPage;
import com.ivana.mobile.pages.swaglabs.InventoryPage;
import com.ivana.mobile.pages.swaglabs.LoginPage;
import com.ivana.mobile.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseSmokeTest extends BaseTest {

    @Test(groups = {"smoke", "purchase"})
    public void standardUserCanCompletePurchase() {
      
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

   
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();
        inventoryPage.openCart();

        
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

    
        CheckoutStepOnePage stepOnePage = new CheckoutStepOnePage(driver);
        stepOnePage.fillCheckoutInformation("Ivana", "Ramirez", "12345");
        stepOnePage.continueToOverview();


        CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage(driver);
        stepTwoPage.finishCheckout();

       
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(
                completePage.isOrderComplete(),
                "Expected order to be completed with THANK YOU message"
        );
    }
}
