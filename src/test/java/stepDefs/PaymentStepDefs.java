package stepDefs;

import desktop.pages.PaymentPage;
import driver.SingletonDriver;
import dto.CardDetailsDTO;
import dto.DeliveryAddressDTO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;


public class PaymentStepDefs {

    PaymentPage paymentPage = new PaymentPage(SingletonDriver.getDriver());

    @DataTableType
    public DeliveryAddressDTO convertAddressDto(Map<String, String> entry) {
        return new DeliveryAddressDTO(
                entry.get("Full name"),
                entry.get("Delivery country"),
                entry.get("Address line 1"),
                entry.get("Address line 2"),
                entry.get("Town/City"),
                entry.get("County/State"),
                entry.get("Postcode")
        );
    }

    @DataTableType
    public CardDetailsDTO convertCardDetails(@Transpose Map<String, String> entry) {
        return new CardDetailsDTO(
                entry.get("Card Number"),
                entry.get("Expiry Year"),
                entry.get("Expiry Month"),
                entry.get("Cvv")
        );
    }

    @When("^I checkout as a new customer with email '([\\w ]{1,}+@[\\w ]{1,}\\.[\\w ]{1,})'$")
    public void checkoutAsNewCustomer(String email) {
        paymentPage.getNewCustomerFragment().enterEmailCustomer(email);
    }

    @When("I fill delivery address information manually:")
    public void fillDeliveryAddressManually(DataTable table) {
        List<DeliveryAddressDTO> dataList = table.asList(DeliveryAddressDTO.class);
        for (DeliveryAddressDTO deliveryAddressDTO : dataList) {
            paymentPage.getNewCustomerFragment().setFullName(deliveryAddressDTO.getFullName());
            paymentPage.getNewCustomerFragment().clickManualButton();
            paymentPage.getNewCustomerFragment()
                    .setDeliveryCountry(deliveryAddressDTO.getDeliveryCountry());
            paymentPage.getNewCustomerFragment()
                    .setAddressLine1(deliveryAddressDTO.getAddressLine1());
            paymentPage.getNewCustomerFragment()
                    .setAddressLine2(deliveryAddressDTO.getAddressLine2());
            paymentPage.getNewCustomerFragment().setCityOrTown(deliveryAddressDTO.getTownOrCity());
            paymentPage.getNewCustomerFragment()
                    .setCountryOrState(deliveryAddressDTO.getCountyOrState());
            paymentPage.getNewCustomerFragment()
                    .setPostcodeOrZip(deliveryAddressDTO.getPostcodeOrZip());
        }
    }

    @When("I enter my card details")
    public void fillCardDetails(Map<String, String> map) {
        CardDetailsDTO cardDetailsDTO = convertCardDetails(map);
        paymentPage.getNewCustomerFragment().setCardNumber(cardDetailsDTO.getCardNumber());
        paymentPage.getNewCustomerFragment()
                .setExpiryMonth(cardDetailsDTO.getExpiryMonth(), cardDetailsDTO.getExpiryYear());
        paymentPage.getNewCustomerFragment().setCvv(cardDetailsDTO.getCvv());
    }

    @Then("Checkout order summary is as following:")
    public void verifyCheckoutOrderSummary(@Transpose Map<String, String> list) {
        assertSoftly(softAssertions -> list
                .forEach((k, v) -> softAssertions
                        .assertThat(
                                paymentPage.getMiniBasketFragment().verifyCheckoutOrderSummary(k))
                        .withFailMessage("Checkout order error")
                        .isEqualTo(v)));
    }

    @Then("There is no validation error messages displayed on 'Delivery Address' form")
    public void verifyNoValidationErrorMessageIsDisplayed() {
        assertThat(paymentPage.getNewCustomerFragment().checkValidationErrorIsDisplayed())
                .withFailMessage("There is validation error message")
                .isTrue();
    }

}




