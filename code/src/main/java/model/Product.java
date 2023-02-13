package model;

public class Product {
    private String description;
    private Double price;
    private Integer quantity;
    private String category;
    private Integer rating;
    private Boolean onSale;

    public Product() {}

    public Product(String description, Double price, Integer quantity, String category, Integer rating, Boolean onSale) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.rating = rating;
        this.onSale = onSale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }
}
