package tests;

import iti.pages.LoginPage;
import iti.pages.SignUpPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{
    SignUpPage SignUpPage;

    @BeforeClass
    public void setUp(){
        SignUpPage= new SignUpPage(driver);
    }
    String expectedResult;
    String actualResult;

    @Test(priority = 0, description = "Registration with Missing Required Fields")
    public void signUpTestCase1(){
        expectedResult="*First Name is required";
        SignUpPage.signUp("","","",0,"","");
        actualResult= SignUpPage.requiredFirstName();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

    @Test(priority = 1, description = "sign up with short name and valid data in other fields")
    public void signUpTestCase2(){
        expectedResult="*First Name must be 3 or more character long";
        SignUpPage.signUp("aa","aaaaa","a@gmail.com",01111111111,"Aa@1212","Aa@1212");
        actualResult= SignUpPage.shortFirstName();
        hardAssert.assertEquals(actualResult,expectedResult);
        SignUpPage.clearSignUpForm();
    }

    @Test(priority = 2, description = "sign up with invalid email address")
    public void signUpTestCase3() {
        expectedResult = "*Enter Valid Email";
        SignUpPage.signUp("TestUser", "Last Name", "invalid_email", 1234567890, "password123", "password123");
        actualResult= SignUpPage.invalidEmail();
        hardAssert.assertEquals(actualResult, expectedResult);
        SignUpPage.clearSignUpForm();
    }

    @Test(priority = 3, description = "sign up with mismatched passwords")
    public void signUpTestCase4() {
        expectedResult = "Password and Confirm Password must match with each other.";
        SignUpPage.signUp("TestUser", "Last Name", "test@example.com", 1234567890, "password123", "password456");
        actualResult= SignUpPage.confirmPassword();
        hardAssert.assertEquals(actualResult, expectedResult);
        SignUpPage.clearSignUpForm();

    }

    @Test(priority = 4, description = "Registration with Invalid Phone Number Format")
    public void signUpWithInvalidPhoneNumber() {
        expectedResult = "*Phone Number must be 10 digit";
        SignUpPage.signUp("TestUser", "Last Name", "test@example.com", 12345, "password123", "password123");
        actualResult= SignUpPage.invalidPhone();
        hardAssert.assertEquals(actualResult, expectedResult);
        SignUpPage.clearSignUpForm();

    }

    @Test(priority = 5, description = "Successful Registration Test")
    public void SuccessfulRegistrationTest() {
        expectedResult = "Account Created Successfully";
        SignUpPage.signUp("TestUser", "Last Name", "aa@aabbb.com", 1111111111, "password@A123", "password@A123");
        actualResult= SignUpPage.SuccessfulRegistration();
        hardAssert.assertEquals(actualResult, expectedResult);
    }
}
