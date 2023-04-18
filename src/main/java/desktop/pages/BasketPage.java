package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.popup.AddToBasketPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static desktop.pages.HomePage.BASE_URL;

public class BasketPage extends AbstractPage {

    public static final String PAGE_URL = BASE_URL + "/basket";
    public static final String TITLE = "Your basket";

    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='checkout-btns-wrap']/a[@href='/payment/guest']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//dl[@class='delivery-text']/dt")
    private WebElement deliveryCost;

    @FindBy(xpath = "//dl[@class='total']/dt")
    private WebElement totalCost;

    private final AddToBasketPopUp addToBasketPopUp;

    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        addToBasketPopUp = new AddToBasketPopUp(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void clickCheckoutButton() {
        waitUntilElementToBeClickable(checkoutButton);
        checkoutButton.click();
    }

    public String verifyBasketOrder(String fieldName) {
        return findElement(By.xpath(
                ".//dt[contains(text(),'" + fieldName + "')]/following-sibling::dd"))
                .getText();
    }

    public AddToBasketPopUp getAddToBasketPopUp() {
        return addToBasketPopUp;
    }
}
