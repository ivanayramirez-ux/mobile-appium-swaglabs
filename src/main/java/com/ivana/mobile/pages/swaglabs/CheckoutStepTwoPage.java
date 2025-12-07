package com.ivana.mobile.pages.swaglabs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckoutStepTwoPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    private final By finishButton = AppiumBy.accessibilityId("test-FINISH");

    public CheckoutStepTwoPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    public void finishCheckout() {
        scrollUntilFinishVisible();

        WebElement finish =
                wait.until(ExpectedConditions.elementToBeClickable(finishButton));

        finish.click();
    }
    

    private void scrollUntilFinishVisible() {
        int maxSwipes = 4;
        for (int i = 0; i < maxSwipes && driver.findElements(finishButton).isEmpty(); i++) {
            Map<String, Object> params = new HashMap<>();
            params.put("left", 100);
            params.put("top", 500);
            params.put("width", 800);
            params.put("height", 1200);
            params.put("direction", "up");
            params.put("percent", 0.8);

            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params);
        }
    }
}