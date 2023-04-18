package desktop.fragments;

import static utils.WebDriverUtils.scrollDown;
import static utils.WebDriverUtils.switchToDefaultContent;
import static utils.WebDriverUtils.switchToIframe;

import abstractClasses.fragment.AbstractFragment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewCustomer extends AbstractFragment {

    @FindBy(xpath = "//div[@class='block-wrap delivery-address']")
    private WebElement fragmentRootElement;

    @FindBy(xpath = "//div[@class='block-wrap delivery-address']//input[@name='emailAddress']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id='manualEntryDeliveryAddress']")
    private WebElement enterAddressManuallyButton;

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//select[@id='delivery-CountryDropdown']")
    private WebElement countryDropDown;

    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
    private WebElement addressLine1Field;

    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
    private WebElement addressLine2Field;

    @FindBy(xpath = "//input[@name='delivery-city']")
    private WebElement townOrCityField;

    @FindBy(xpath = "//input[@name='delivery-county']")
    private WebElement countryOrStateField;

    @FindBy(xpath = "//input[@name='delivery-postCode']")
    private WebElement postcodeOrZipField;

    @FindBy(xpath = "//input[@id='credit-card-number']")
    private WebElement cardNumberField;

    @FindBy(xpath = "//input[@id='expiration']")
    private WebElement expiryDateField;

    @FindBy(xpath = "//input[@id='cvv']")
    private WebElement cvvField;

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-number']")
    private WebElement cardNumberIFrame;

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-expirationDate']")
    private WebElement expiryDateIFrame;

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-cvv']")
    private WebElement cvvIFrame;

    public NewCustomer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkValidationErrorIsDisplayed() {
        List<WebElement> errorsList = findElements(By.xpath("//div[@class='error-block']"));
        return errorsList.stream().noneMatch(error -> Boolean.parseBoolean(error.getText()));
    }

    public void enterEmailCustomer(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setFullName(String name) {
        fullNameField.clear();
        fullNameField.sendKeys(name);
    }

    public void setDeliveryCountry(String country) {
        Select select = new Select(countryDropDown);
        select.selectByVisibleText(country);
    }

    public void setAddressLine1(String addressLine1) {
        addressLine1Field.clear();
        addressLine1Field.sendKeys(addressLine1);
    }

    public void setAddressLine2(String addressLine2) {
        addressLine2Field.clear();
        addressLine2Field.sendKeys(addressLine2);
    }

    public void setCityOrTown(String cityOrTown) {
        townOrCityField.clear();
        townOrCityField.sendKeys(cityOrTown);
    }

    public void setCountryOrState(String countryOrState) {
        countryOrStateField.clear();
        countryOrStateField.sendKeys(countryOrState);
    }

    public void setPostcodeOrZip(String postcodeOrZip) {
        postcodeOrZipField.clear();
        postcodeOrZipField.sendKeys(postcodeOrZip);
    }

    public void clickManualButton() {
        enterAddressManuallyButton.click();
    }

    public void setCardNumber(String cardNumber) {
        scrollDown();
        switchToIframe(cardNumberIFrame);
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
        switchToDefaultContent();
    }

    public void setExpiryMonth(String expiryMonth, String expiryYear) {
        switchToIframe(expiryDateIFrame);
        expiryDateField.clear();
        expiryDateField.sendKeys(expiryMonth);
        expiryDateField.sendKeys(expiryYear);
        switchToDefaultContent();
    }

    public void setCvv(String cvv) {
        switchToIframe(cvvIFrame);
        cvvField.clear();
        cvvField.sendKeys(cvv);
    }

    @Override
    public boolean verifyCheckoutOrderSummary(String k) {
        return false;
    }
}
