package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckouPage extends BasePage{

    public CheckouPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement countryField;

    @FindBy(css = ".ta-results")
    List<WebElement> result;

    @FindBy(css = ".action__submit")
    WebElement checkoutButton;

    @FindBy(css = ".item__details .item__title")
    WebElement itemTitle;

    @FindBy(css = ".item__details .item__price")
    WebElement itemPrice;


    public String getItemTitle() {
        return itemTitle.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public void EnterLocation(String location) {
        countryField.sendKeys(location);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        wait.until(ExpectedConditions.visibilityOf(result.getFirst()));

        for (WebElement option : result) {
            if (option.getText().toLowerCase().contains(location)) {
                option.click();
                break;
            }
        }
    }

    public void CompleteOrder() {
        checkoutButton.click();
    }
}
