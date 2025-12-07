package com.ivana.mobile.pages.swaglabs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

   
    private final By thankYouLabel =
            AppiumBy.xpath("//android.widget.TextView[contains(@text,'THANK YOU')]");

    public CheckoutCompletePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getConfirmationText() {
        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(thankYouLabel)
        );
        return label.getText();
    }

    public boolean isOrderComplete() {
        String text = getConfirmationText();
        return text != null && text.toUpperCase().contains("THANK YOU");
    }
}
