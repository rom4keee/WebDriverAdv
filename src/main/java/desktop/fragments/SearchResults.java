package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends AbstractFragment {

    @FindBy(xpath = "put your locator expression here")
    private WebElement fragmentRootElement;

    @FindBy(xpath = "//div[@class='book-item']//h3[@class='title']")
    private WebElement itemTitle;

    @FindBy(xpath = "//div[@class='book-item']")
    private WebElement bookItem;

    public SearchResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getBookItemsTitles() {
        return findElements(By.xpath("//div[@class='book-item']//h3[@class='title']"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<WebElement> findElements(By locator) {
        return fragmentRootElement.findElements(locator);
    }

    @Override
    public boolean verifyCheckoutOrderSummary(String k) {
        return false;
    }
}
