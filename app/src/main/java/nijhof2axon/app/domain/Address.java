package nijhof2axon.app.domain;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class Address {

    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;

    public Address(String street, String streetNumber, String postalCode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
