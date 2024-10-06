package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardPage extends BasePage{

    public CardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='heading cf'] h1")
    WebElement myCardField;

    @FindBy(css = "div[class='cartSection'] h3")
    WebElement productNameField;

    @FindBy(css = "div[class='prodTotal cartSection'] p")
    WebElement productPriceField;


    public String chickProductName() {
        waitForElementVisibility(myCardField);
        return productNameField.getText();
    }

    public String chickProductPrice() {
        waitForElementVisibility(myCardField);
        return productPriceField.getText();
    }
}
