package model;

public class Person {
    private String name;
    private String email;
    private String mobilePhone;
    private String federalTax;
    private String birthDate;
    private Address address;

    public Person() {}

    public Person(String name, String email, String mobilePhone, String federalTax, String birthDate, Address address) {
        this.name = name;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.federalTax = federalTax;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(String federalTax) {
        this.federalTax = federalTax;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
