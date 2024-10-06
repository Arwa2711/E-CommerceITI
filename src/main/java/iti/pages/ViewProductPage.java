package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewProductPage extends BasePage{

    public ViewProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='col-lg-6 rtl-text'] div h2")
    WebElement productNameField;

    @FindBy(css = "div[class='col-lg-6 rtl-text'] div h3")
    WebElement productPriceField;

    @FindBy(css = "div[class='border-product'] p")
    WebElement productDescriptionField;

    public String viewProductName() {
        waitForElementVisibility(productNameField);
        return productNameField.getText();
    }

    public String viewProductPrice() {
        waitForElementVisibility(productPriceField);
        return productPriceField.getText();
    }

    public String viewProductDescription() {
        waitForElementVisibility(productDescriptionField);
        return productDescriptionField.getText();
    }
}
