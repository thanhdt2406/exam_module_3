package model;

public class Product {
    private int productID;
    private String productName;
    private int price;
    private int amount;
    private String color;
    private String description;
    private Category category;

    public Product() {

    }

    public Product(int productID, String productName, int price, int amount, String color, String description, Category category) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
