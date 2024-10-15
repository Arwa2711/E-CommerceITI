package tests;

import iti.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        loginPage= new LoginPage(driver);
    }
    String expectedResult;
    String actualResult;

    @Test(priority = 0, description = "Login with empty user email and password")
    public void LoginWithEmptyUserEmailAndPassword(){
        expectedResult="*Password is required";
        loginPage.login("","");
        actualResult= loginPage.requiredPassword();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

    @Test(priority = 1, description = "Login with valid user email and invalid password")
    public void LoginWithValidUserEmailAndInvalidPassword(){
        expectedResult="Incorrect email or password.";
         loginPage.login("arwa@gmail.com","27C5B@");
         actualResult= loginPage.wrongData();
        hardAssert.assertEquals(actualResult,expectedResult);
        loginPage.clearLogInForm();
    }

    @Test(priority = 2, description = "Login with invalid user email and valid password")
    public void LoginWithInvalidUserEmailAndValidPassword(){
        expectedResult="Incorrect email or password.";
        loginPage.login("arwa@gmail","Aa@12345");
        actualResult= loginPage.wrongData();
        hardAssert.assertEquals(actualResult,expectedResult);
        loginPage.clearLogInForm();
    }

    @Test(priority = 3,groups = "login", description = "Login with valid user email and valid password")
    public void loginSuccessfully(){
        expectedResult="HOME";
        loginPage.login("arwa@gmail.com","Aa@12345");
        actualResult= loginPage.homeField();
        hardAssert.assertEquals(actualResult,expectedResult);
    }
}
