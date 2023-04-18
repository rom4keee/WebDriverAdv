package desktop.fragments.popup;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToBasketPopUp extends AbstractPage {

    @FindBy(xpath = "//div[@class='basket-info']//a[@href='/basket']")
    private WebElement basketCheckoutButton;

    public AddToBasketPopUp(WebDriver driver) {
        super(driver);
    }

    public void clickBasketCheckoutButton() {
        basketCheckoutButton.click();
    }
}
