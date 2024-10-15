# Ecommerce Test Automation Project

This project is a Test Automation framework built using **Java**, **Maven**, and **Selenium WebDriver**. The framework is designed to automate end-to-end testing of a web-based e-commerce application. It includes page object classes representing different parts of the web application and test classes to validate functionality.

## Project Structure

- **src/main/java**: Contains the Page Object Model (POM) classes representing the web pages.
  - `BasePage`: The base class for common web page functionalities.
  - `SignUpPage`: Handles interactions with the user registration page.
  - `ViewProductPage`: Represents the product details view.
  - `CartPage`: Interacts with the shopping cart page.
  - `CheckoutPage`: Automates the checkout process.
  - `CompleteOrderPage`: Represents the page confirming an order.
  - `HomePage`: Automates interactions with the homepage.
  - `LoginPage`: Manages the login functionalities.
  - `HistoryPage`: Automates interactions with the order history page.

- **src/test/java**: Contains test classes that validate the functionalities of the web pages.
  - `AddProductToCard`: Tests adding products to the cart.
  - `LogOutTest`: Tests the logout functionality.
  - `LoginTest`: Verifies login functionality.
  - `BaseTest`: The base test class for common test setup and teardown.
  - `CompleteOrderPageTest`: Tests the order completion process.
  - `OrderHistoryTest`: Tests the order history page.
  - `CartTests`: Tests cart functionalities like viewing and updating the cart.
  - `CheckoutPageTest`: Tests the checkout process.
  - `ViewProductDetailsTest`: Tests viewing product details.
  - `SignUpTest`: Tests user registration and sign-up functionalities.

## Prerequisites

1. **Java**: Ensure you have Java Development Kit (JDK) 8 or later installed.
2. **Maven**: The project uses Maven for dependency management. Ensure Maven is installed and added to your system path.
3. **Selenium WebDriver**: The framework uses Selenium WebDriver for interacting with web browsers.
4. **WebDriver**: Download the necessary WebDriver for the browser you are automating (e.g., ChromeDriver for Google Chrome).

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository-url
   cd project-directory
   ```
2. Install Dependencies
   ```bash
   mvn clean install
   ```
3. Download and set up the WebDriver binary for the browser in the system path.

4. Install Intellij IDE
5. Run the testng.xml file
