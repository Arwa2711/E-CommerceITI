package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement RegisterField;

    @FindBy(css = "input#firstName")
    WebElement firstNameField;

    @FindBy(css = "input#lastName")
    WebElement lastNameField;

    @FindBy(css = "input#userEmail")
    WebElement userEmailField;

    @FindBy(css = "input#userMobile")
    WebElement userMobileField;

    @FindBy(css = "input#userPassword")
    WebElement userPasswordField;

    @FindBy(css = "input#confirmPassword")
    WebElement confirmPasswordField;

    @FindBy(css = "input[type='checkbox']")
    WebElement checkAgeField;

    @FindBy(css = "input[type='submit']")
    WebElement submitField;

    @FindBy(xpath = "//*[text()='*First Name is required']")
    WebElement requiredFirstName;

    @FindBy(xpath = "//*[text()='*First Name must be 3 or more character long']")
    WebElement shortFirstName;

    @FindBy(xpath = "//*[text()='*Enter Valid Email']")
    WebElement invalidEmail;

    @FindBy(xpath = "//*[text()='Password and Confirm Password must match with each other.']")
    WebElement confirmPassword;

    @FindBy(xpath = "//*[text()='*Phone Number must be 10 digit']")
    WebElement invalidPhone;

    @FindBy(xpath = "//*[text()='Account Created Successfully']")
    WebElement SuccessfulRegistration;

    public void signUp(String firstName, String lastName, String userEmail, int userMobile,
                       String userPassword, String confirmPassword) {

        waitForElementVisibility(RegisterField);
        RegisterField.click();

        waitForElementVisibility(firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        userEmailField.sendKeys(userEmail);
        userMobileField.sendKeys(String.valueOf(userMobile));
        userPasswordField.sendKeys(userPassword);
        confirmPasswordField.sendKeys(confirmPassword);
        checkAgeField.click();
        submitField.click();
    }

    public String requiredFirstName() {
        waitForElementVisibility(requiredFirstName);
        return requiredFirstName.getText();
    }

    public String shortFirstName() {
        waitForElementVisibility(shortFirstName);
        return shortFirstName.getText();
    }

    public String invalidEmail() {
        waitForElementVisibility(invalidEmail);
        return invalidEmail.getText();
    }

    public String confirmPassword() {
        waitForElementVisibility(confirmPassword);
        return confirmPassword.getText();
    }

    public String invalidPhone() {
        waitForElementVisibility(invalidPhone);
        return invalidPhone.getText();
    }

    public String SuccessfulRegistration() {
        waitForElementVisibility(SuccessfulRegistration);
        return SuccessfulRegistration.getText();
    }

    public void clearSignUpForm() {
        firstNameField.clear();
        lastNameField.clear();
        userEmailField.clear();
        userMobileField.clear();
        userPasswordField.clear();
        confirmPasswordField.clear();
    }
}
