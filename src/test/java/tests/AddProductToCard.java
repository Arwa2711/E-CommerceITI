package tests;

import iti.pages.HomePage;
import iti.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductToCard extends BaseTest{
        HomePage homePage;

        @BeforeClass
        public void setUp(){
            homePage= new HomePage(driver);
        }

        String expectedResult;
        String actualResult;

    @Test(priority = 0, description = "add product to the card")
        public void addProductToCard(){
            expectedResult="Product Added To Cart";
            LoginPage loginPage =new LoginPage(driver);
            loginPage.login("arwa@gmail.com","Aa@12345");
            actualResult= homePage.addProductToCard();
            hardAssert.assertEquals(actualResult,expectedResult);
        }

    @Test(dependsOnMethods = "addProductToCard",priority = 1, description = "View Products Details")
        public void ViewProductsDetails(){
        expectedResult="product details";
        actualResult= homePage.viewProduct();
        hardAssert.assertEquals(actualResult,expectedResult);
        }

    @Test(dependsOnMethods = "ViewProductsDetails",priority = 2, description = "add product to the card in the view page")
        public void addProductToCardInViewPage(){
        expectedResult="Product Added To Cart";
        actualResult= homePage.addProductToCardInView();
        hardAssert.assertEquals(actualResult,expectedResult);
         }

}
