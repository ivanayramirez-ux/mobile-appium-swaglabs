package com.ivana.mobile.pages.swaglabs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    private final By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
    }

    public void proceedToCheckout() {
        waitForPageToLoad();
        WebElement checkout = wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        );
        checkout.click();
    }
}
