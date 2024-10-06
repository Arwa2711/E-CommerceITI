package tests;

import iti.pages.CartPage;
import iti.pages.CheckouPage;
import iti.pages.HomePage;
import iti.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest{
    CheckouPage checkouPage;

    @BeforeClass
    public void init(){
        checkouPage = new CheckouPage(driver);
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");

        HomePage homePage =new HomePage(driver);
        homePage.addProductToCard();
        homePage.goToCartPage();

        CartPage CartPage =new CartPage(driver);
        CartPage.goToCheckoutPage();
    }

    String expectedResult;
    String actualResult;


    @Test
    public void checkItemTitle() {
        expectedResult = "ZARA COAT 3";
        actualResult = checkouPage.getItemTitle();
        hardAssert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void checkItemPrice() {
        expectedResult = "$ 31500";
        actualResult = checkouPage.getItemPrice();
        hardAssert.assertEquals(actualResult, expectedResult);
    }

}
