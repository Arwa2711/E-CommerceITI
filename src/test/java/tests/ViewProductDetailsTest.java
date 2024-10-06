package tests;

import iti.pages.HomePage;
import iti.pages.LoginPage;
import iti.pages.ViewProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewProductDetailsTest extends BaseTest{
    ViewProductPage viewProductPage;

    @BeforeClass
    public void setUp(){
        viewProductPage= new ViewProductPage(driver);
    }

    String expectedResult;
    String actualResult;

    @Test(description = "Chick the product name")
    public void chickTheProductName(){
        expectedResult="ZARA COAT 3";
        LoginPage loginPage =new LoginPage(driver);
        loginPage.login("arwa@gmail.com","Aa@12345");

        HomePage homePage =new HomePage(driver);
        homePage.viewProduct();

        actualResult= viewProductPage.viewProductName();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

    @Test(dependsOnMethods = "chickTheProductName",priority = 1, description = "Chick the product price")
    public void chickTheProductPrice(){
        expectedResult="$ 31500";
        actualResult= viewProductPage.viewProductPrice();
        hardAssert.assertEquals(actualResult,expectedResult);
    }

    @Test(dependsOnMethods = "chickTheProductName",priority = 2, description = "Chick the product description")
    public void chickTheProductDescription(){
        expectedResult="Zara coat for Women and girls";
        actualResult= viewProductPage.viewProductDescription();
        hardAssert.assertEquals(actualResult,expectedResult);
    }


}
