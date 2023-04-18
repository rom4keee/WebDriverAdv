package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiniBasket extends AbstractFragment {

    @FindBy(xpath = "//div[@class='mini-basket']")
    private WebElement rootElement;

    @Override
    public boolean verifyCheckoutOrderSummary(String k) {
        return false;
    }

    public MiniBasket(WebDriver driver) {
    }

    public String getCheckoutOrderSummaryValue(String fieldName) {
        WebElement fieldElement = rootElement.findElement(
                By.xpath("//dt/strong[contains(text(),'" + fieldName
                        + "')]/ancestor::dt/following-sibling::dd")
        );
        return fieldElement.getText();
    }
}
