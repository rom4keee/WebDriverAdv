package dto;

public class DeliveryAddressDTO {

    String fullName;
    String deliveryCountry;
    String addressLine1;
    String addressLine2;
    String townOrCity;
    String countyOrState;
    String postcodeOrZip;

    public DeliveryAddressDTO(String fullName, String deliveryCountry, String addressLine1,
                              String addressLine2, String townOrCity, String countyOrState,
                              String postcodeOrZip) {
        this.fullName = fullName;
        this.deliveryCountry = deliveryCountry;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townOrCity = townOrCity;
        this.countyOrState = countyOrState;
        this.postcodeOrZip = postcodeOrZip;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getTownOrCity() {
        return townOrCity;
    }

    public String getCountyOrState() {
        return countyOrState;
    }

    public String getPostcodeOrZip() {
        return postcodeOrZip;
    }
}
