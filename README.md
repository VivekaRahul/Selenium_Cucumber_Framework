Demoblaze E-Commerce Automation (Selenium + Cucumber BDD)
This project automates the complete purchase workflow on the Demoblaze E-Commerce website using Selenium WebDriver, Java, Cucumber BDD, and JUnit.
It covers two end-to-end scenarios, validating both positive and negative flows.

Project Overview
The automation suite performs a full UI test of the Demoblaze website—from launching the application to placing an order and verifying the purchase confirmation.
The framework uses Cucumber feature files, reusable step definitions, Page Object concepts, and explicit waits to ensure stability.

 Automated Scenarios Included
1️⃣ Purchase Samsung Galaxy S6,
Scroll to the mobile product,
Open product details and add to cart,
Handle pop-up alert,
Navigate to cart,
Click Place Order,
Validate the error alert by clicking Purchase without entering details.
Fill the purchase form with valid data,
Complete the order and verify the success message.
Capture the purchase confirmation screenshot.

2️⃣ Purchase MacBook Pro
Navigate to the Laptops category,
Scroll to the MacBook Pro product,
Open product details and add to cart,
Handle alert,
Navigate to the cart and place an order,
Verify alert for missing purchase details,
Fill out the form and complete the purchase.
Validate the success message and take a screenshot.

Key Features
Full end-to-end automation for product purchase
Cucumber BDD with readable scenarios
Reusable Selenium step definitions
Robust synchronization using WebDriverWait
UI operations using JavaScriptExecutor
Automatic screenshots on successful purchase
Cucumber HTML reports for test execution

Tech Stack
Java
Selenium WebDriver
Cucumber (BDD)
JUnit
ChromeDriver
