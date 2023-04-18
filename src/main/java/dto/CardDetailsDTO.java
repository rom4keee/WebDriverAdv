package dto;

public class CardDetailsDTO {

    String cardNumber;
    String expiryYear;
    String expiryMonth;
    String cvv;

    public CardDetailsDTO(String cardNumber, String expiryYear, String expiryMonth,
                          String cvv) {
        this.cardNumber = cardNumber;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getCvv() {
        return cvv;
    }
}
