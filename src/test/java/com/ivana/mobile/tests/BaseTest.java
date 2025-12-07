package com.ivana.mobile.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import com.ivana.mobile.core.DriverFactory;

public abstract class BaseTest {

	protected AppiumDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void globalSetUp() {

		DriverFactory.createDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		driver = DriverFactory.getDriver();
	}

	@AfterSuite(alwaysRun = true)
	public void globalTearDown() {
		DriverFactory.quitDriver();
	}
}
