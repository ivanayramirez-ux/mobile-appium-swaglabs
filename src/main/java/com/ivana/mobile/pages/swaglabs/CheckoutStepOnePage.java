package com.ivana.mobile.pages.swaglabs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOnePage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    private final By firstNameField   = AppiumBy.accessibilityId("test-First Name");
    private final By lastNameField    = AppiumBy.accessibilityId("test-Last Name");
    private final By postalCodeField  = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private final By continueButton   = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckoutStepOnePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        first.clear();
        first.sendKeys(firstName);

        WebElement last = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        last.clear();
        last.sendKeys(lastName);

        WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        zip.clear();
        zip.sendKeys(postalCode);
    }

    public void continueToOverview() {
        WebElement cont = wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        );
        cont.click();
    }
}
