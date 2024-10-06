package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.col-lg-4")
    WebElement cardField;

    @FindBy(css = "body > app-root:nth-child(1) > app-dashboard:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(4)")
    WebElement AddTCardField;


    @FindBy(css = "div[aria-label='Product Added To Cart']")
    WebElement SuccessfulAddTCardField;

    @FindBy(css = "body > app-root:nth-child(1) > app-dashboard:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(3)\n")
    WebElement ViewProductsField;

    @FindBy(xpath = "//*[text()='Add to Cart']")
    WebElement AddTCardFieldInView;


    @FindBy(css = "div[aria-label='Product Added To Cart']")
    WebElement SuccessfulAddTCardFieldInView;

    @FindBy(xpath = "//*[text()='product details']")
    WebElement productDetailsField;

    @FindBy(css = ".fa.fa-sign-out")
    WebElement signOutField;

    @FindBy(css = "div[aria-label='Logout Successfully']")
    WebElement successfulSignOutField;

    @FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
    WebElement cartField;

    @FindBy(css = ".btn.btn-custom[routerlink='/dashboard/myorders']")
    WebElement historyPage;

    public String addProductToCard() {
        waitForElementVisibility(cardField);
        AddTCardField.click();
        waitForElementVisibility(SuccessfulAddTCardField);
        return SuccessfulAddTCardField.getText();
    }

    public String viewProduct() {
        waitForElementVisibility(ViewProductsField);
        ViewProductsField.click();
        return productDetailsField.getText();
    }

    public String addProductToCardInView() {
        waitForElementVisibility(AddTCardFieldInView);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AddTCardFieldInView.click();
        return SuccessfulAddTCardFieldInView.getText();
    }

    public String signOut() {
        waitForElementVisibility(signOutField);
        signOutField.click();
        return successfulSignOutField.getText();
    }

    public void goToCartPage() {
        waitForElementVisibility(cartField);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cartField.click();
    }

    public void goToHistoryPage() {
        waitForElementVisibility(historyPage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        historyPage.click();
    }
}
