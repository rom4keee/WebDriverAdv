package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import io.cucumber.datatable.DataTable;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFilter extends AbstractFragment {

    @FindBy(xpath = "//form[@class='filter-menu']")
    private WebElement fragmentRootElement;

    @FindBy(xpath = "//form[@class='filter-menu']//button[@type='submit']")
    private WebElement submitButton;

    public SearchFilter(WebDriver driver) {
        PageFactory.initElements(SingletonDriver.getDriver(), this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void selectOption(DataTable table) {
        Map<String, String> list = table.asMap(String.class, String.class);
        for (String key : list.keySet()) {
            SingletonDriver.getDriver()
                    .findElement(By.xpath("//option[@label='" + list.get(key) + "']"))
                    .click();
        }
    }

    @Override
    public boolean verifyCheckoutOrderSummary(String k) {
        return false;
    }
}
