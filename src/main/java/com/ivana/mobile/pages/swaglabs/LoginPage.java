package com.ivana.mobile.pages.swaglabs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    // Login screen locators
    private final By usernameField = AppiumBy.accessibilityId("test-Username");
    private final By passwordField = AppiumBy.accessibilityId("test-Password");
    private final By loginButton   = AppiumBy.accessibilityId("test-LOGIN");
    private final By errorBanner   = AppiumBy.accessibilityId("test-Error message");

    // Inventory / menu locators (for logging out)
    private final By menuButton   = AppiumBy.accessibilityId("test-Menu");
    private final By logoutButton = AppiumBy.accessibilityId("test-LOGOUT");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

 
    public void open() {
        try {
           
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        } catch (TimeoutException e) {
            
            try {
                WebElement menu = driver.findElement(menuButton);
                menu.click();

                WebDriverWait menuWait =
                        new WebDriverWait(driver, Duration.ofSeconds(10));
                menuWait.until(ExpectedConditions
                        .visibilityOfElementLocated(logoutButton));

                driver.findElement(logoutButton).click();

           
                WebDriverWait loginWait =
                        new WebDriverWait(driver, Duration.ofSeconds(10));
                loginWait.until(ExpectedConditions
                        .visibilityOfElementLocated(usernameField));

            } catch (Exception ex) {
               
                throw new RuntimeException(
                        "Could not navigate back to login screen without restarting the app",
                        ex
                );
            }
        }
    }

    public void login(String username, String password) {
        WebElement user = driver.findElement(usernameField);
        WebElement pass = driver.findElement(passwordField);
        WebElement btn  = driver.findElement(loginButton);

        user.clear();
        user.sendKeys(username);

        pass.clear();
        pass.sendKeys(password);

        btn.click();
    }

    public boolean isErrorVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorBanner));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
