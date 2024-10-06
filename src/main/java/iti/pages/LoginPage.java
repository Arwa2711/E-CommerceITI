package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "userEmail")
    WebElement emailField;

    @FindBy(id = "userPassword")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(css = "div.ng-star-inserted")
    WebElement requiredEmail;

    @FindBy(xpath = "//*[text()='*Password is required']")
    WebElement requiredPassword;

    @FindBy(className = "toast-error")
    WebElement wrongError;

    @FindBy(css = "button.btn.btn-custom")
    WebElement homeField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userEmail, String password) {

        waitForElementVisibility(emailField);

        emailField.sendKeys(userEmail);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String wrongData() {
        waitForElementVisibility(wrongError);
        return wrongError.getText();
    }

    public String requiredEmail() {
        waitForElementVisibility(requiredEmail);
        return requiredEmail.getText();
    }

    public String requiredPassword() {
        waitForElementVisibility(requiredPassword);
        return requiredPassword.getText();
    }

    public String homeField() {
        waitForElementVisibility(homeField);
        return homeField.getText();
    }
    public void clearLogInForm() {
        emailField.clear();
        passwordField.clear();
    }
}
