package model;

public class Address {
    private String country;
    private String stateUF;
    private String city;
    private String street;
    private String addressNumber;
    private String neighborhood;
    private String zip;

    public Address() {}

    public Address(String country, String stateUF, String city, String street, String addressNumber, String neighborhood, String zip) {
        this.country = country;
        this.stateUF = stateUF;
        this.city = city;
        this.street = street;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateUF() {
        return stateUF;
    }

    public void setStateUF(String stateUF) {
        this.stateUF = stateUF;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
