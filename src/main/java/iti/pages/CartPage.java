package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='heading cf'] h1")
    WebElement myCardField;

    @FindBy(css = "div[class='cartSection'] h3")
    WebElement productNameField;

    @FindBy(css = "div[class='prodTotal cartSection'] p")
    WebElement productPriceField;

    @FindBy(css = ".subtotal button")
    WebElement checkoutButton;


    public String checkProductName() {
        waitForElementVisibility(myCardField);
        return productNameField.getText();
    }

    public String checkProductPrice() {
        waitForElementVisibility(myCardField);
        return productPriceField.getText();
    }
    public void goToCheckoutPage(){
        checkoutButton.click();
    }
}
