package tests;

import iti.pages.CardPage;
import iti.pages.HomePage;
import iti.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CardTests extends BaseTest{
    CardPage cardPage;

    @BeforeClass
    public void setUp(){
        cardPage= new CardPage(driver);
    }

    String expectedResult;
    String actualResult;

    @Test(priority = 0, description = "Chick the product name")
    public void chickTheProductName(){
        expectedResult="ZARA COAT 3";
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");

        HomePage homePage =new HomePage(driver);
        homePage.addProductToCard();
        homePage.goToCartPage();

        actualResult= cardPage.chickProductName();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

    @Test(dependsOnMethods = "chickTheProductName",priority = 1, description = "Chick the product price")
    public void chickTheProductPrice(){
        expectedResult="$ 31500";
        actualResult= cardPage.chickProductPrice();
        hardAssert.assertEquals(actualResult,expectedResult);
    }
}
