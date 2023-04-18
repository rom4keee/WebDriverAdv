package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.BookItem;
import desktop.fragments.SearchFilter;
import desktop.fragments.SearchResults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    private static final String BASE_URL = "https://www.bookdepository.com";
    private static final String PAGE_URL = BASE_URL + "/search";
    public static final String TITLE = "Results for 'Thinking in Java' | Book Depository";

    private final BookItem bookItemFragment;
    private final SearchResults searchResultsFragment;
    private final SearchFilter searchFilterFragment;

    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    public SearchPage(WebDriver driver) {
        super(driver);
        bookItemFragment = new BookItem(driver);
        searchResultsFragment = new SearchResults(driver);
        searchFilterFragment = new SearchFilter(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public BookItem getBookItemFragment() {
        return bookItemFragment;
    }

    public SearchResults getSearchResultsFragment() {
        return searchResultsFragment;
    }

    public SearchFilter getSearchFilterFragment() {
        return searchFilterFragment;
    }

    public static String getPageUrl() {
        return PAGE_URL;
    }

    public static String getPageTitleText() {
        return TITLE;
    }
}
