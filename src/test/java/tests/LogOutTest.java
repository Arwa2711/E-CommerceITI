package tests;

import iti.pages.HomePage;
import iti.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{
    HomePage homePage;

    @BeforeClass
    public void setUp(){
        homePage= new HomePage(driver);
    }

    String expectedResult;
    String actualResult;

    @Test(priority = 0, description = "sign out")
    public void lgOut(){
        expectedResult="Logout Successfully";
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");
        actualResult= homePage.signOut();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

}
