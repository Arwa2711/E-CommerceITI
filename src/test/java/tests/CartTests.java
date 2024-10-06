package tests;

import iti.pages.CartPage;
import iti.pages.HomePage;
import iti.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{
    CartPage cartPage;

    @BeforeClass
    public void setUp(){
        cartPage= new CartPage(driver);
    }

    String expectedResult;
    String actualResult;

    @BeforeTest
    public void loginAndGoToCart(){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");

        HomePage homePage =new HomePage(driver);
        homePage.addProductToCard();
        homePage.goToCartPage();
    }

    @Test(description = "Chick the product name")
    public void checkTheProductName(){
        expectedResult="ZARA COAT 3";
        actualResult= cartPage.checkProductName();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

    @Test(dependsOnMethods = "checkTheProductName",priority = 1, description = "checkTheProductPrice")
    public void checkTheProductPrice(){
        expectedResult="$ 31500";
        actualResult= cartPage.checkProductPrice();
        hardAssert.assertEquals(actualResult,expectedResult);
    }
}
