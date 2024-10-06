package iti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HistoryPage extends BasePage{

    @FindBy(css = "tbody tr td:nth-of-type(2)")
    List<WebElement> products;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkProductInHistory(String productName) {
        return products.stream().anyMatch(product -> product.getText().contains(productName));
    }

}
