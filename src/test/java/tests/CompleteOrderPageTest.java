package tests;

import iti.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompleteOrderPageTest extends BaseTest {
    CompleteOrderPage completeOrderPage;

    @BeforeClass
    public void init(){
        completeOrderPage = new CompleteOrderPage(driver);
    }

    String expectedResult;
    String actualResult;


    @BeforeTest
    public void setUp(){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");

        HomePage homePage =new HomePage(driver);
        homePage.addProductToCard();
        homePage.goToCartPage();

        CartPage CartPage =new CartPage(driver);
        CartPage.goToCheckoutPage();

        CheckouPage checkouPage = new CheckouPage(driver);
        checkouPage.EnterLocation("british");
        checkouPage.CompleteOrder();
    }

    @Test
    public void checkSuccessMessage() {
        expectedResult = "THANKYOU FOR THE ORDER.";
        actualResult = completeOrderPage.getSuccessMessage();
        hardAssert.assertEquals(actualResult, expectedResult);
    }
}
