package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.MiniBasket;
import desktop.fragments.NewCustomer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractPage {

    public static final String TITLE;

    static {
        TITLE = "Your basket";
    }

    private final MiniBasket miniBasketFragment;
    private final NewCustomer newCustomerFragment;

    public PaymentPage(WebDriver driver) {
        super(driver);
        miniBasketFragment = new MiniBasket(driver);
        newCustomerFragment = new NewCustomer(driver);
        PageFactory.initElements(driver, this);
    }

    public MiniBasket getMiniBasketFragment() {
        return miniBasketFragment;
    }

    public NewCustomer getNewCustomerFragment() {
        return newCustomerFragment;
    }
}
