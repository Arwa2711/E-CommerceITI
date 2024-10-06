package tests;

import iti.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderHistoryTest extends  BaseTest{
    HistoryPage historyPage;

    @BeforeClass
    public void init(){
        historyPage = new HistoryPage(driver);
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");

        HomePage homePage =new HomePage(driver);
        homePage.goToHistoryPage();
    }


    @Test
    public void checkItemInHistory() {
        boolean result = historyPage.checkProductInHistory("ZARA COAT 3");
        hardAssert.assertTrue(result);
    }
    @Test
    public void checkItemInHistoryInvalid() {
        boolean result = historyPage.checkProductInHistory("ZARA COAT 333");
        hardAssert.assertFalse(result);
    }
}
