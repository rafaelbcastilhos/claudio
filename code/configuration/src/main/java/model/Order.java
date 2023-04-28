package model;

public class Order {
    private Person shipper;
    private Person transporter;
    private Person destinator;
    private Products products;
    private Double totalPrice;
    private char deliveryMethod;

    public Order() {}

    public Order(Person shipper, Person transporter, Person destinator, Products products, Double totalPrice, char deliveryMethod) {
        this.shipper = shipper;
        this.transporter = transporter;
        this.destinator = destinator;
        this.products = products;
        this.totalPrice = totalPrice;
        this.deliveryMethod = deliveryMethod;
    }

    public Person getShipper() {
        return shipper;
    }

    public void setShipper(Person shipper) {
        this.shipper = shipper;
    }

    public Person getTransporter() {
        return transporter;
    }

    public void setTransporter(Person transporter) {
        this.transporter = transporter;
    }

    public Person getDestinator() {
        return destinator;
    }

    public void setDestinator(Person destinator) {
        this.destinator = destinator;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public char getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(char deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
