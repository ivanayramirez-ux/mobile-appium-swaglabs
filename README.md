<h1>Mobile Automation Framework – SwagLabs (Appium, Java, TestNG)</h1>

<p>
This project is a native mobile test automation framework for the SwagLabs Android application.
It is built using <strong>Appium 2.x</strong>, <strong>Java 17</strong>, <strong>TestNG</strong>, and the 
<strong>Page Object Model</strong> structure.
</p>

<p>
The framework executes three core flows in a single Appium session:
</p>

<ul>
  <li>Standard user login</li>
  <li>Locked-out user negative login</li>
  <li>End-to-end purchase flow</li>
</ul>

<hr>

<h2>Project Structure</h2>

<pre>
mobile-appium-swaglabs/
├── pom.xml
├── README.md
├── .gitignore
│
├── apps/
│   └── SwagLabs.apk
│
├── config/
│   └── env-local.properties
│
├── src/main/java/com/ivana/mobile/
│   ├── core/
│   │   ├── DriverFactory.java
│   │   └── ConfigLoader.java
│   │
│   ├── pages/swaglabs/
│   │   ├── LoginPage.java
│   │   ├── InventoryPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutStepOnePage.java
│   │   ├── CheckoutStepTwoPage.java
│   │   └── CheckoutCompletePage.java
│   │
│   └── utils/
│       └── Waits.java
│
├── src/test/java/com/ivana/mobile/tests/
│   ├── BaseTest.java
│   ├── smoke/
│   │   ├── LoginSmokeTest.java
│   │   └── PurchaseSmokeTest.java
│   └── negative/
│       └── LockedOutUserLoginTest.java
│
└── src/test/resources/
    └── testng-smoke.xml
</pre>

<hr>

<h2>Technology Stack</h2>

<ul>
  <li>Appium 2.x (UIAutomator2 driver)</li>
  <li>Java 17</li>
  <li>TestNG</li>
  <li>Selenium 4.34</li>
  <li>Maven</li>
  <li>Page Object Model (POM) pattern</li>
</ul>

<hr>

<h2>Running the Tests</h2>

<h3>1. Start Appium Server</h3>
<pre>appium</pre>

<h3>2. Launch your Android Emulator</h3>
<pre>adb devices</pre>

<h3>3. Execute the TestNG Suite</h3>
<pre>mvn clean test</pre>

<p>This command executes the tests defined in <code>testng-smoke.xml</code>.</p>

<hr>

<h2>Test Scenarios Covered</h2>

<h3>Smoke Tests</h3>
<ul>
  <li>Valid user login</li>
  <li>Add-to-cart and checkout flow</li>
</ul>

<h3>Negative Test</h3>
<ul>
  <li>Locked-out user login verification</li>
</ul>

<hr>

<h2>Configuration</h2>

<p>The file <code>config/env-local.properties</code> controls:</p>

<ul>
  <li>Platform</li>
  <li>Device name</li>
  <li>Appium server URL</li>
  <li>Application path</li>
</ul>

<p>Example:</p>

<pre>
platform=Android
deviceName=Medium Phone API 36
appiumServerUrl=http://127.0.0.1:4723
appName=SwagLabs.apk
</pre>

<hr>

<h2>Page Object Model</h2>

<p>
Each screen is represented as its own class under:
</p>

<pre>/src/main/java/com/ivana/mobile/pages/swaglabs</pre>

<p>
Every page includes:
</p>

<ul>
  <li>Locators</li>
  <li>Wait logic</li>
  <li>Reusable interactions</li>
  <li>Page validation methods</li>
</ul>

<hr>

<h2>Single Session Execution</h2>

<p>
The framework uses a single Appium session across all tests to improve performance and reduce restart delays.  
The driver is created once in <code>@BeforeSuite</code> and closed in <code>@AfterSuite</code>.
</p>

<hr>
