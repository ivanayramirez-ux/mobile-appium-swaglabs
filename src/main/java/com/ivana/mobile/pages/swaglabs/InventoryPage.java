package com.ivana.mobile.pages.swaglabs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class InventoryPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;
    private final By productsTitle = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");


   
    private final By cartIcon = AppiumBy.accessibilityId("test-Cart");

    
    private final By firstItemAddToCartButton =
            AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");

    public InventoryPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
    }
    
    public boolean isLoaded() {
    	WebElement title = wait.until(
    			ExpectedConditions.visibilityOfElementLocated(productsTitle)
    			);
    	return title.isDisplayed();
    
    }

    public void addFirstItemToCart() {
        waitForPageToLoad();
        WebElement addBtn = wait.until(
                ExpectedConditions.elementToBeClickable(firstItemAddToCartButton)
        );
        addBtn.click();
    }

    public void openCart() {
        WebElement cart = wait.until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        );
        cart.click();
    }
}
