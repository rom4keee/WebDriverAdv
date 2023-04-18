package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class BookItem extends AbstractFragment {

    @FindBy(xpath = "//div[@class='book-item']")
    private WebElement fragmentRootElement;
    private WebElement rootElement;

    public BookItem(WebDriver driver) {
        super();
        setRootElement(fragmentRootElement);
        setPageFactory(driver, this);
    }

    private void setPageFactory(WebDriver driver, BookItem bookItem) {
    }

    public void clickAddToBasketButton(String productTitle) {
        List<WebElement> booksList = findElements(By.xpath("//div[@class='book-item']"));
        WebElement bookElement = booksList.stream()
                .filter(book -> book.findElement(By.xpath(".//h3[@class='title']/a")).getText()
                        .equals(productTitle))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No book found"));

        WebElement addToBasketButton = bookElement.findElement(By.xpath(".//div[@class='item-actions']//a"));
        addToBasketButton.click();
    }

    public void setRootElement(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    @Override
    public boolean verifyCheckoutOrderSummary(String k) {
        return false;
    }
}
