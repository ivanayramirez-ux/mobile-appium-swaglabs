package com.ivana.mobile.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriver createDriver() {
        try {
           
            if (driver != null) {
                return driver;
            }

            Properties props = ConfigLoader.load();
            driver = createLocalDriver(props);
            return driver;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Appium driver", e);
        }
    }

    
    public static AppiumDriver getDriver() {
        return driver;
    }

    private static AppiumDriver createLocalDriver(Properties props) throws Exception {

        String platform   = props.getProperty("platform", "Android").trim();
        String deviceName = props.getProperty("deviceName", "Android Emulator").trim();
        String serverUrl  = props.getProperty("appiumServerUrl", "http://127.0.0.1:4723").trim();
        String appName    = props.getProperty("appName", "SwagLabs.apk").trim();

        Path appPath = Paths.get(
                System.getProperty("user.dir"),
                "apps",
                appName
        );

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(platform)
                .setDeviceName(deviceName)
                .setAutomationName("UIAutomator2")
                .setApp(appPath.toString())
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.SplashActivity")
                .setAppWaitPackage("com.swaglabsmobileapp")
                .setAppWaitActivity("*")
                .setAutoGrantPermissions(true)
                .setNewCommandTimeout(Duration.ofSeconds(300));

     
        options.setCapability("appium:noReset", true);
        options.setCapability("appium:fullReset", false);
        

        return new AndroidDriver(new URL(serverUrl), options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
